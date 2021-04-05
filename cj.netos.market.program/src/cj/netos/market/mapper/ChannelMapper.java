package cj.netos.market.mapper;

import cj.netos.market.model.Channel;
import cj.netos.market.model.ChannelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChannelMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(ChannelExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(ChannelExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Channel record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Channel record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Channel> selectByExample(ChannelExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Channel selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") Channel record, @Param("example") ChannelExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") Channel record, @Param("example") ChannelExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Channel record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Channel record);

    List<Channel> listChannel(@Param(value = "source") String source,@Param(value = "site")  String site);

}