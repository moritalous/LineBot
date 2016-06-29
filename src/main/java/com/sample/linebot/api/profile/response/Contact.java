
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
    "displayName",
    "mid",
    "pictureUrl",
    "statusMessage"
})
public class Contact {

    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("mid")
    private String mid;
    @JsonProperty("pictureUrl")
    private String pictureUrl;
    @JsonProperty("statusMessage")
    private String statusMessage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The displayName
     */
    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 
     * @param displayName
     *     The displayName
     */
    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * 
     * @return
     *     The mid
     */
    @JsonProperty("mid")
    public String getMid() {
        return mid;
    }

    /**
     * 
     * @param mid
     *     The mid
     */
    @JsonProperty("mid")
    public void setMid(String mid) {
        this.mid = mid;
    }

    /**
     * 
     * @return
     *     The pictureUrl
     */
    @JsonProperty("pictureUrl")
    public String getPictureUrl() {
        return pictureUrl;
    }

    /**
     * 
     * @param pictureUrl
     *     The pictureUrl
     */
    @JsonProperty("pictureUrl")
    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    /**
     * 
     * @return
     *     The statusMessage
     */
    @JsonProperty("statusMessage")
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * 
     * @param statusMessage
     *     The statusMessage
     */
    @JsonProperty("statusMessage")
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
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
