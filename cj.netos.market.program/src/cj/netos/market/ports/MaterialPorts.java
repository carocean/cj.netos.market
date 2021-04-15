package cj.netos.market.ports;

import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.ISecuritySession;
import cj.ultimate.gson2.com.google.gson.Gson;
import com.taobao.api.ApiException;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.request.TbkDgOptimusMaterialRequest;
import com.taobao.api.request.TbkTpwdCreateRequest;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import com.taobao.api.response.TbkDgOptimusMaterialResponse;
import com.taobao.api.response.TbkTpwdCreateResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CjService(name = "/material.ports")
public class MaterialPorts extends AbstractPorts implements IMaterialPorts {
    @Override
    public List<Map<String, Object>> pageMaterial(ISecuritySession session, long materialId, long limit, long offset) throws CircuitException {
        TbkDgOptimusMaterialRequest req = new TbkDgOptimusMaterialRequest();
        req.setPageSize(limit);
        req.setAdzoneId(getAdzoneId());
        req.setPageNo(offset);
        req.setMaterialId(materialId);
//        req.setDeviceValue("xxx");
//        req.setDeviceEncrypt("MD5");
//        req.setDeviceType("IMEI");
//        req.setContentId(323L);
//        req.setContentSource("xxx");
//        req.setItemId(9653L);
//        req.setFavoritesId("123445");
        TbkDgOptimusMaterialResponse rsp = null;
        try {
            rsp = client().execute(req);
            String json = rsp.getBody();
            Map<String, Object> data = new Gson().fromJson(json, HashMap.class);
            if (data.containsKey("error_response")) {
                Map<String, Object> error = (Map<String, Object>) data.get("error_response");
                if ("50001".equals(error.get("sub_code"))) {
                    return new ArrayList<>();
                }
            }

            Map<String, Object> response = (Map<String, Object>) data.get("tbk_dg_optimus_material_response");
            Map<String, Object> resultList = (Map<String, Object>) response.get("result_list");
            List<Map<String, Object>> mapData = (List<Map<String, Object>>) resultList.get("map_data");
            return mapData;
        } catch (ApiException e) {
            throw new CircuitException("500", e);
        }
    }

    @Override
    public List<Map<String, Object>> searchMaterial(ISecuritySession session, String query, long materialId, long limit, long offset) throws CircuitException {
        TbkDgMaterialOptionalRequest req = new TbkDgMaterialOptionalRequest();
        req.setPageSize(limit);
        req.setAdzoneId(getAdzoneId());
        req.setPageNo(offset);
//        req.setMaterialId(materialId);
        req.setQ(query);
        req.setSort("tk_rate_des");
        req.setHasCoupon(true);
        List<TbkDgMaterialOptionalRequest.Ucrowdrankitems> list2 = new ArrayList<TbkDgMaterialOptionalRequest.Ucrowdrankitems>();
//        TbkDgMaterialOptionalRequest.Ucrowdrankitems obj3 = new TbkDgMaterialOptionalRequest.Ucrowdrankitems();
//        list2.add(obj3);
//        obj3.setCommirate(1234L);
//        obj3.setPrice("10.12");
//        obj3.setItemId("542808901898");
        req.setUcrowdRankItems(list2);
        TbkDgMaterialOptionalResponse rsp = null;
        try {
            rsp = client().execute(req);
            String json = rsp.getBody();
            Map<String, Object> data = new Gson().fromJson(json, HashMap.class);
            if (data.containsKey("error_response")) {
                Map<String, Object> error = (Map<String, Object>) data.get("error_response");
                if ("50001".equals(error.get("sub_code"))) {
                    return new ArrayList<>();
                }
            }

            Map<String, Object> response = (Map<String, Object>) data.get("tbk_dg_material_optional_response");
            Map<String, Object> resultList = (Map<String, Object>) response.get("result_list");
            List<Map<String, Object>> mapData = (List<Map<String, Object>>) resultList.get("map_data");
            return mapData;
        } catch (ApiException e) {
            throw new CircuitException("500", e);
        }
    }

    @Override
    public Map<String, Object> createTaoPWD(ISecuritySession session, String userId, String text, String url, String logo) throws CircuitException {
        TbkTpwdCreateRequest req = new TbkTpwdCreateRequest();
        req.setUserId(userId);
        req.setText(text);
        req.setUrl(url);
        req.setLogo(logo);
        req.setExt("{}");
        try {
            TbkTpwdCreateResponse rsp = client().execute(req);
            String json = rsp.getBody();
            Map<String, Object> data = new Gson().fromJson(json, HashMap.class);
            if (data.containsKey("error_response")) {
                Map<String, Object> error = (Map<String, Object>) data.get("error_response");
                if ("50001".equals(error.get("sub_code"))) {
                    return new HashMap<>();
                }
            }
            Map<String, Object> response = (Map<String, Object>) data.get("tbk_tpwd_create_response");
            Map<String, Object> dataMap= (Map<String, Object>) response.get("data");
            return dataMap;
        } catch (ApiException e) {
            throw new CircuitException("500", e);
        }
    }
//
//    @Override
//    public Map<String, Object> pageTaobaoOrder(ISecuritySession session, long query_type, long tk_status, String start_time, String end_time) throws CircuitException {
//        TbkScOrderDetailsGetRequest req = new TbkScOrderDetailsGetRequest();
//        req.setQueryType(1L);
//        req.setPositionIndex("2222_334666");
//        req.setPageSize(20L);
//        req.setMemberType(2L);
//        req.setTkStatus(12L);
//        req.setEndTime("2019-04-23 12:28:22");
//        req.setStartTime("2019-04-05 12:18:22");
//        req.setJumpType(1L);
//        req.setPageNo(1L);
//        req.setOrderScene(1L);
//        TbkScOrderDetailsGetResponse rsp = client().execute(req, sessionKey);
//        System.out.println(rsp.getBody());
//        return null;
//    }
}
