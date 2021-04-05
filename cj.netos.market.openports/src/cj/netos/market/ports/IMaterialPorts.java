package cj.netos.market.ports;

import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;
import java.util.Map;

@CjOpenports(usage = "物料服务")
public interface IMaterialPorts extends IOpenportService {

    @CjOpenport(usage = "分页物料")
    List<Map<String,Object>> pageMaterial(
            ISecuritySession session,
          @CjOpenportParameter(usage = "阿里物料编码",name = "materialId") long materialId,
            @CjOpenportParameter(usage = "页大小",name = "limit") long limit,
            @CjOpenportParameter(usage = "页码",name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "分页物料")
    List<Map<String,Object>> searchMaterial(
            ISecuritySession session,
            @CjOpenportParameter(usage = "关键词",name = "query") String query,
            @CjOpenportParameter(usage = "阿里物料编码",name = "materialId") long materialId,
            @CjOpenportParameter(usage = "页大小",name = "limit") long limit,
            @CjOpenportParameter(usage = "页码",name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "生成淘口令")
    Map<String, Object> createTaoPWD(
            ISecuritySession session,
            @CjOpenportParameter(usage = "生成口令的淘宝用户ID",name = "userId") String userId,
            @CjOpenportParameter(usage = "口令弹框内容",name = "text") String text,
            @CjOpenportParameter(usage = "口令跳转目标页",name = "url") String url,
            @CjOpenportParameter(usage = "口令弹框logoURL",name = "logo") String logo
    ) throws CircuitException;

//    @CjOpenport(usage = "淘宝客订单查询")
//    Map<String, Object> pageTaobaoOrder(
//            ISecuritySession session,
//            @CjOpenportParameter(usage = "查询时间类型，1：按照订单淘客创建时间查询，2:按照订单淘客付款时间查询，3:按照订单淘客结算时间查询",name = "query_type") long query_type,
//            @CjOpenportParameter(usage = "淘客订单状态，12-付款，13-关闭，14-确认收货，3-结算成功;不传，表示所有状态",name = "tk_status") long tk_status,
//            @CjOpenportParameter(usage = "订单查询开始时间",name = "start_time") String start_time,
//            @CjOpenportParameter(usage = "订单查询结束时间，订单开始时间至订单结束时间，中间时间段日常要求不超过3个小时，但如618、双11、年货节等大促期间预估时间段不可超过20分钟，超过会提示错误，调用时请务必注意时间段的选择，以保证亲能正常调用！",name = "end_time") String end_time
//    ) throws CircuitException;
}
