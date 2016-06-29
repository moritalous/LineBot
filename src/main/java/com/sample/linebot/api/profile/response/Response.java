
package com.sample.linebot.api.profile.response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "contacts",
    "count",
    "display",
    "pagingRequest",
    "start",
    "total"
})
public class Response {

    @JsonProperty("contacts")
    private List<Contact> contacts = new ArrayList<Contact>();
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("display")
    private Integer display;
    @JsonProperty("pagingRequest")
    private PagingRequest pagingRequest;
    @JsonProperty("start")
    private Integer start;
    @JsonProperty("total")
    private Integer total;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The contacts
     */
    @JsonProperty("contacts")
    public List<Contact> getContacts() {
        return contacts;
    }

    /**
     * 
     * @param contacts
     *     The contacts
     */
    @JsonProperty("contacts")
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    /**
     * 
     * @return
     *     The count
     */
    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The count
     */
    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 
     * @return
     *     The display
     */
    @JsonProperty("display")
    public Integer getDisplay() {
        return display;
    }

    /**
     * 
     * @param display
     *     The display
     */
    @JsonProperty("display")
    public void setDisplay(Integer display) {
        this.display = display;
    }

    /**
     * 
     * @return
     *     The pagingRequest
     */
    @JsonProperty("pagingRequest")
    public PagingRequest getPagingRequest() {
        return pagingRequest;
    }

    /**
     * 
     * @param pagingRequest
     *     The pagingRequest
     */
    @JsonProperty("pagingRequest")
    public void setPagingRequest(PagingRequest pagingRequest) {
        this.pagingRequest = pagingRequest;
    }

    /**
     * 
     * @return
     *     The start
     */
    @JsonProperty("start")
    public Integer getStart() {
        return start;
    }

    /**
     * 
     * @param start
     *     The start
     */
    @JsonProperty("start")
    public void setStart(Integer start) {
        this.start = start;
    }

    /**
     * 
     * @return
     *     The total
     */
    @JsonProperty("total")
    public Integer getTotal() {
        return total;
    }

    /**
     * 
     * @param total
     *     The total
     */
    @JsonProperty("total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
