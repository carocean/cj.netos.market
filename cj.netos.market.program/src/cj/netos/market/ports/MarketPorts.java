package cj.netos.market.ports;

import cj.netos.market.IMarketService;
import cj.netos.market.model.Channel;
import cj.netos.market.model.EcSource;
import cj.netos.market.model.Site;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import cj.ultimate.gson2.com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CjService(name = "/market.ports")
public class MarketPorts implements IMarketPorts {
    @CjServiceRef
    IMarketService marketService;
    @Override
    public void config(ISecuritySession session, String json) throws CircuitException {
        List<Map<String, Object>> data = new Gson().fromJson(json, ArrayList.class);
        marketService.config(data);
    }

    @Override
    public List<EcSource> listSource(ISecuritySession session) throws CircuitException {
        return marketService.listSource();
    }

    @Override
    public List<Site> listSite(ISecuritySession session, String source) throws CircuitException {
        return marketService.listSite(source);
    }

    @Override
    public List<Channel> listChannel(ISecuritySession session, String source, String site) throws CircuitException {
        return marketService.listChannel(source,site);
    }
}
