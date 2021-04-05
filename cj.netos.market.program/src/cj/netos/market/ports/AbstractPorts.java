package cj.netos.market.ports;

import cj.studio.ecm.IServiceSite;
import cj.studio.ecm.annotation.CjServiceSite;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;

public abstract class AbstractPorts {
    @CjServiceSite
    IServiceSite site;
    TaobaoClient client ;
   protected TaobaoClient client(){
       if (client != null) {
           return client;
       }
       String url=site.getProperty("taobao.url");
       String appkey = site.getProperty("taobao.appkey");
       String secret = site.getProperty("taobao.secret");
       TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
       this.client=client;
       return client;
    }
    protected long getAdzoneId(){
        return Long.valueOf(site.getProperty("taobao.adzoneId"));
    }
}
