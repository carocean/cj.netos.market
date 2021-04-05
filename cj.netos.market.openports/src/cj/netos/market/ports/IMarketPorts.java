package cj.netos.market.ports;

import cj.netos.market.model.Channel;
import cj.netos.market.model.EcSource;
import cj.netos.market.model.Site;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.PKeyInRequest;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "市场")
public interface IMarketPorts extends IOpenportService {
    @CjOpenport(usage = "配置市场信息，每次先清空再添加", command = "post")
    void config(
            ISecuritySession session,
            @CjOpenportParameter(usage = "配置表", name = "json", in = PKeyInRequest.content) String json
    ) throws CircuitException;

    @CjOpenport(usage = "列出所有电商源",elementType = EcSource.class)
    List<EcSource> listSource(
            ISecuritySession session
    ) throws CircuitException;

    @CjOpenport(usage = "列出所有电商源站点",elementType = Site.class)
    List<Site> listSite(
            ISecuritySession session,
            @CjOpenportParameter(usage = "电商源", name = "source") String source
    ) throws CircuitException;

    @CjOpenport(usage = "列出所有电商源站点中的频道",elementType = Channel.class)
    List<Channel> listChannel(
            ISecuritySession session,
            @CjOpenportParameter(usage = "电商源", name = "source") String source,
            @CjOpenportParameter(usage = "站点", name = "site") String site
    ) throws CircuitException;
}
