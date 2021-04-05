package cj.netos.market.mapper;

import cj.netos.market.model.Site;
import cj.netos.market.model.SiteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SiteMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(SiteExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(SiteExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Site record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Site record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Site> selectByExample(SiteExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Site selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") Site record, @Param("example") SiteExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") Site record, @Param("example") SiteExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Site record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Site record);

    List<Site> listSite(@Param(value = "source") String source);

}