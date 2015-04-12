/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gocodecolorado.entities;

import java.util.*;

/**
 *
 * @author rsjodin
 */
public class CapNeed {

    public enum Type {Need, Capability};
    
    private int id = 0;
    private String name = "";
    private String description = "";
    private Type type = null;
    private List<String> keywords = new ArrayList<String>();
    private String startDate;
    private String endDate;
    private String publishStartDate;
    private String publishEndDtate;

        /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getName() {
        return name;
    }

    /**
     * @param title the title to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * @return the keywords
     */
    public List<String> getKeywords() {
        return keywords;
    }

    /**
     * @param keywords the keywords to set
     */
    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
    
        /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the publishStartDate
     */
    public String getPublishStartDate() {
        return publishStartDate;
    }

    /**
     * @param publishStartDate the publishStartDate to set
     */
    public void setPublishStartDate(String publishStartDate) {
        this.publishStartDate = publishStartDate;
    }

    /**
     * @return the publishEndDtate
     */
    public String getPublishEndDtate() {
        return publishEndDtate;
    }

    /**
     * @param publishEndDtate the publishEndDtate to set
     */
    public void setPublishEndDtate(String publishEndDtate) {
        this.publishEndDtate = publishEndDtate;
    }

}
