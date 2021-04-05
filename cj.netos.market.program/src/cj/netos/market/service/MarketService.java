package cj.netos.market.service;

import cj.netos.market.IMarketService;
import cj.netos.market.mapper.ChannelMapper;
import cj.netos.market.mapper.EcSourceMapper;
import cj.netos.market.mapper.SiteMapper;
import cj.netos.market.model.*;
import cj.netos.market.util.IdWorker;
import cj.netos.market.util.Utils;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.List;
import java.util.Map;

@CjBridge(aspects = "@transaction")
@CjService(name = "marketService")
public class MarketService implements IMarketService {
    @CjServiceRef(refByName = "mybatis.cj.netos.market.mapper.EcSourceMapper")
    EcSourceMapper ecSourceMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.market.mapper.SiteMapper")
    SiteMapper siteMapper;
    @CjServiceRef(refByName = "mybatis.cj.netos.market.mapper.ChannelMapper")
    ChannelMapper channelMapper;

    @CjTransaction
    @Override
    public void config(List<Map<String, Object>> data) {
        empty();
        for (Map<String, Object> sourceObj : data) {
            EcSource ecSource = createEcSource(sourceObj);
            ecSourceMapper.insert(ecSource);
            List<Map<String, Object>> sites = (List<Map<String, Object>>) sourceObj.get("sites");
            if (sites == null) {
                continue;
            }
            for (Map<String, Object> siteObj : sites) {
                Site site = createSite(ecSource.getId(), siteObj);
                siteMapper.insert(site);
                List<Map<String, Object>> channels = (List<Map<String, Object>>) siteObj.get("channels");
                if (channels == null) {
                    continue;
                }
                for (Map<String, Object> channelObj : channels) {
                    Channel channel = createChannel(ecSource.getId(), site.getId(), channelObj);
                    channelMapper.insert(channel);
                }
            }
        }
    }

    @CjTransaction
    @Override
    public List<EcSource> listSource() {
        return ecSourceMapper.listSource();
    }

    @CjTransaction
    @Override
    public List<Site> listSite(String source) {
        return siteMapper.listSite( source);
    }

    @CjTransaction
    @Override
    public List<Channel> listChannel(String source, String site) {
        return channelMapper.listChannel(source,site);
    }

    private Channel createChannel(String source, String site, Map<String, Object> obj) {
        Channel channel = new Channel();
        channel.setSource(source);
        channel.setSite(site);
        channel.setCode((String) obj.get("code"));
        channel.setTitle((String) obj.get("title"));
        channel.setSort(Double.valueOf(obj.get("sort") + "").intValue());
        channel.setCtime(Utils.dateTimeToMicroSecond(System.currentTimeMillis()));
        channel.setId(new IdWorker().nextId());
        return channel;
    }

    private Site createSite(String source, Map<String, Object> obj) {
        Site site = new Site();
        site.setId(new IdWorker().nextId());
        site.setCtime(Utils.dateTimeToMicroSecond(System.currentTimeMillis()));
        site.setSort(Double.valueOf(obj.get("sort") + "").intValue());
        site.setSource(source);
        site.setTitle((String) obj.get("title"));
        return site;
    }

    private void empty() {
        EcSourceExample ecSourceExample = new EcSourceExample();
        ecSourceExample.createCriteria();
        ecSourceMapper.deleteByExample(ecSourceExample);

        SiteExample siteExample = new SiteExample();
        siteExample.createCriteria();
        siteMapper.deleteByExample(siteExample);

        ChannelExample channelExample = new ChannelExample();
        channelExample.createCriteria();
        channelMapper.deleteByExample(channelExample);
    }

    private EcSource createEcSource(Map<String, Object> source) {
        EcSource ecSource = new EcSource();
        ecSource.setId((String) source.get("id"));
        ecSource.setCtime(Utils.dateTimeToMicroSecond(System.currentTimeMillis()));
        ecSource.setState(Double.valueOf(source.get("state") + "").intValue());
        ecSource.setTitle((String) source.get("title"));
        return ecSource;
    }
}
