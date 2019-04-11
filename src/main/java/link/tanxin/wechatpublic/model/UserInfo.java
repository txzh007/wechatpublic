package link.tanxin.wechatpublic.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_info", schema = "wechat_dev", catalog = "")
public class UserInfo {
    private String id;
    private String nickname;
    private String mobile;
    private Byte sex;
    private String openid;
    private String country;
    private String language;
    private String headimgurl;
    private Timestamp modifiedTime;
    private Timestamp subscribeTime;
    private String city;
    private Byte subscribe;
    private String subscribeScene;
    private String province;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "sex")
    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "openid")
    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "language")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Basic
    @Column(name = "headimgurl")
    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    @Basic
    @Column(name = "modified_time")
    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Basic
    @Column(name = "subscribe_time")
    public Timestamp getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Timestamp subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "subscribe")
    public Byte getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Byte subscribe) {
        this.subscribe = subscribe;
    }

    @Basic
    @Column(name = "subscribe_scene")
    public String getSubscribeScene() {
        return subscribeScene;
    }

    public void setSubscribeScene(String subscribeScene) {
        this.subscribeScene = subscribeScene;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(id, userInfo.id) &&
                Objects.equals(nickname, userInfo.nickname) &&
                Objects.equals(mobile, userInfo.mobile) &&
                Objects.equals(sex, userInfo.sex) &&
                Objects.equals(openid, userInfo.openid) &&
                Objects.equals(country, userInfo.country) &&
                Objects.equals(language, userInfo.language) &&
                Objects.equals(headimgurl, userInfo.headimgurl) &&
                Objects.equals(modifiedTime, userInfo.modifiedTime) &&
                Objects.equals(subscribeTime, userInfo.subscribeTime) &&
                Objects.equals(city, userInfo.city) &&
                Objects.equals(subscribe, userInfo.subscribe) &&
                Objects.equals(subscribeScene, userInfo.subscribeScene);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, mobile, sex, openid, country, language, headimgurl, modifiedTime, subscribeTime, city, subscribe, subscribeScene);
    }

    @Basic
    @Column(name = "province")
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
