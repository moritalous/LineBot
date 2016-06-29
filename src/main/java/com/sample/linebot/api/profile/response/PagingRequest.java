
package com.sample.linebot.api.profile.response;

import java.util.HashMap;
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
    "start",
    "display",
    "sortBy"
})
public class PagingRequest {

    @JsonProperty("start")
    private Integer start;
    @JsonProperty("display")
    private Integer display;
    @JsonProperty("sortBy")
    private String sortBy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The sortBy
     */
    @JsonProperty("sortBy")
    public String getSortBy() {
        return sortBy;
    }

    /**
     * 
     * @param sortBy
     *     The sortBy
     */
    @JsonProperty("sortBy")
    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
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
