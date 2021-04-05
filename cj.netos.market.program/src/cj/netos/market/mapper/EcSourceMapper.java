package cj.netos.market.mapper;

import cj.netos.market.model.EcSource;
import cj.netos.market.model.EcSourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EcSourceMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(EcSourceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(EcSourceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(EcSource record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(EcSource record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<EcSource> selectByExample(EcSourceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    EcSource selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") EcSource record, @Param("example") EcSourceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") EcSource record, @Param("example") EcSourceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(EcSource record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(EcSource record);

    List<EcSource> listSource();

}