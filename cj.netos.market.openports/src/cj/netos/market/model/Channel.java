package cj.netos.market.model;

/**
 * Table: channel
 */
public class Channel {
    /**
     * Column: id
     * Remark: 代码
     */
    private String id;

    /**
     * Column: code
     * Remark: 对应电商真实的物料代码 在淘宝里指向materialId
     */
    private String code;

    /**
     * Column: title
     * Remark: 显示标题
     */
    private String title;

    /**
     * Column: site
     * Remark: 归属站点
     */
    private String site;

    /**
     * Column: source
     * Remark: 归属电商源
     */
    private String source;

    /**
     * Column: sort
     */
    private Integer sort;

    /**
     * Column: ctime
     */
    private String ctime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site == null ? null : site.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime == null ? null : ctime.trim();
    }
}