package com.ckz.core.entity;

import java.util.Date;

public class MpUserDo {
    /**
     * 用户id，主键自增
     * id
     */
    private Long id;

    /**
     * 是否删除状态，1：删除，0：有效
     * is_delete
     */
    private Byte isDelete;

    /**
     * 创建时间
     * create_time
     */
    private Date createTime;

    /**
     * 修改时间
     * modify_time
     */
    private Date modifyTime;

    /**
     * 创建人
     * creater
     */
    private String creater;

    /**
     * 修改人
     * modifier
     */
    private String modifier;

    /**
     * 用户名
     * username
     */
    private String username;

    /**
     * 密码
     * password
     */
    private String password;

    /**
     * 手机号
     * phone
     */
    private String phone;

    /**
     * 性别 0男 1女  3未知
     * sex
     */
    private Byte sex;

    /**
     * 昵称
     * nick
     */
    private String nick;

    /**
     * 出生年月日，格式yyyy-MM-dd
     * birthday
     */
    private String birthday;

    /**
     *  冒泡ID （随机生成一个八位数）
     * mp_label
     */
    private String mpLabel;

    /**
     * 高德地图云存储id
     * amap_id
     */
    private Long amapId;

    /**
     * 对接融云token
     * token
     */
    private String token;

    /**
     * 用户随机uuid
     * uuid
     */
    private String uuid;

    /**
     * 用户类型 0普通用户 1虚拟用户 2官方账号 3冒泡小助手 4 达人认证 5即是虚拟用户又是达人 6直播间虚拟用户 7 派单室主持人 8 公开课导师 9 代售泡泡币代理 10 求生活动注册用户 11 游客用户信息 12 直播官方账号  13 运营人员  14 巡管人员
     * user_type
     */
    private Byte userType;

    /**
     * 设备类型  a安卓  i IOS
     * net_type
     */
    private String netType;

    /**
     * APP版本号
     * app_version
     */
    private String appVersion;

    /**
     * 下载渠道
     * down_channel
     */
    private String downChannel;

    /**
     * 设备号
     * equip_num
     */
    private String equipNum;

    /**
     * 渠道id
     * channel_id
     */
    private Long channelId;

    /**
     * ios设备
     * idfa
     */
    private String idfa;

    /**
     * 注册ip
     * ip
     */
    private String ip;

    /**
     * 家族拉新
     * pull_family_id
     */
    private Long pullFamilyId;

    /**
     * app包渠道  0冒泡 1阿拉show 2渠道包1
     * app_id
     */
    private Integer appId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMpLabel() {
        return mpLabel;
    }

    public void setMpLabel(String mpLabel) {
        this.mpLabel = mpLabel;
    }

    public Long getAmapId() {
        return amapId;
    }

    public void setAmapId(Long amapId) {
        this.amapId = amapId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Byte getUserType() {
        return userType;
    }

    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    public String getNetType() {
        return netType;
    }

    public void setNetType(String netType) {
        this.netType = netType;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getDownChannel() {
        return downChannel;
    }

    public void setDownChannel(String downChannel) {
        this.downChannel = downChannel;
    }

    public String getEquipNum() {
        return equipNum;
    }

    public void setEquipNum(String equipNum) {
        this.equipNum = equipNum;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getPullFamilyId() {
        return pullFamilyId;
    }

    public void setPullFamilyId(Long pullFamilyId) {
        this.pullFamilyId = pullFamilyId;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }
}