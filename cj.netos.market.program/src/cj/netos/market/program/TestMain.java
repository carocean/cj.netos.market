package cj.netos.market.program;


import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) throws ApiException {
        //mm_1751060114_2260650464_111276750046
        String url="https://eco.taobao.com/router/rest";
        String appkey = "32586230";
        String secret = "e7865c485b274bb795d505702a9dbd0c";
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        TbkDgMaterialOptionalRequest req = new TbkDgMaterialOptionalRequest();
        req.setPageSize(20L);
        req.setAdzoneId(111276750046L);
        req.setPageNo(1L);
        req.setMaterialId(3767L);

        req.setQ("法式");

        List<TbkDgMaterialOptionalRequest.Ucrowdrankitems> list2 = new ArrayList<TbkDgMaterialOptionalRequest.Ucrowdrankitems>();
//        TbkDgMaterialOptionalRequest.Ucrowdrankitems obj3 = new TbkDgMaterialOptionalRequest.Ucrowdrankitems();
//        list2.add(obj3);
//        obj3.setCommirate(1234L);
//        obj3.setPrice("10.12");
//        obj3.setItemId("542808901898");
        req.setUcrowdRankItems(list2);
        TbkDgMaterialOptionalResponse rsp = client.execute(req);
        System.out.println(rsp.getBody());
    }
}
