package cj.netos.market;

import cj.netos.market.model.Channel;
import cj.netos.market.model.EcSource;
import cj.netos.market.model.Site;

import java.util.List;
import java.util.Map;

public interface IMarketService {
    void config(List<Map<String, Object>> data);

    List<EcSource> listSource();

    List<Site> listSite(String source);

    List<Channel> listChannel(String source, String site);

}
