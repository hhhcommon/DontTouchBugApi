//package com.zhengshun.touch.api.user.service;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.Random;
//import java.util.UUID;
//
//import javax.annotation.Resource;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.alibaba.fastjson.JSON;
//import com.zhengshun.donttouchbug.api.user.bean.AppDbSession;
//import com.zhengshun.donttouchbug.api.user.bean.AppSessionBean;
//import com.zhengshun.touch.api.user.bean.AppDbSession;
//import com.zhengshun.touch.api.user.bean.AppSessionBean;
//import com.zhiliao.social.api.user.bean.AppDbSession;
//import com.zhiliao.social.api.user.bean.AppSessionBean;
//import com.zhiliao.social.core.common.util.*;
//import com.zhiliao.social.core.service.SoUserAuthorizedService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import tool.util.BeanUtil;
//import tool.util.DateUtil;
//
//import com.zhiliao.social.cl.domain.BankCard;
//import com.zhiliao.social.cl.domain.Channel;
//import com.zhiliao.social.cl.domain.OperatorReqLog;
//import com.zhiliao.social.cl.model.SmsModel;
////import com.zhiliao.social.cl.service.BankCardService;
////import com.zhiliao.social.cl.service.ChannelService;
//import com.zhiliao.social.cl.service.SoSmsService;
////import com.zhiliao.social.cl.service.OperatorReqLogService;
////import com.zhiliao.social.cl.service.UserAuthService;
////import com.zhiliao.social.cl.service.UserEquipmentInfoService;
//import com.zhiliao.social.core.common.context.Global;
//import com.zhiliao.social.core.service.SoUserService;
//
///**
// * Created by lsk on 2016/7/27.
// */
//@Service("clUserService_")
//@SuppressWarnings({ "rawtypes", "unchecked" })
//public class UserService {
//
//    private Logger logger = LoggerFactory.getLogger(UserService.class);
//
//    @Autowired
//    private AppDbSession appDbSession;
//
//    @Resource
//    protected DBService dbService;
//
//    @Resource
//    protected MybatisService mybatisService;
//
//    @Resource
//    protected SmsService smsService;
//
////    @Resource
////	private UserEquipmentInfoService userEquipmentInfoService;
////
////	@Resource
////	private UserAuthService userAuthService;
////
////	@Resource
////	private BankCardService bankCardService;
////
////	@Resource
////	private OperatorReqLogService operatorReqLogService;
//
//	@Resource
//	private SoUserService soUserService;
//
//	@Resource
//    private SoUserAuthorizedService soUserAuthorizedService;
//
//
//    public UserService() {
//        super();
//    }
//
//	@Transactional
//    public Map registerUser(HttpServletRequest request, String identifier, String credential,String identityType,
//                            String vcode, String invitationCode,String registerCoordinate,String registerAddr,String regClient) {
//        try {
//            if (StringUtil.isEmpty(identifier)  || StringUtil.isEmpty(credential) || StringUtil.isEmpty(vcode) || credential.length() < 32) {
//                Map ret = new LinkedHashMap();
//                ret.put("success", false);
//                ret.put("msg", "参数有误");
//                return ret;
//            }
//
//            //发送短信验证码
//            SoSmsService soSmsService = (SoSmsService)BeanUtil.getBean("soSmsService");
//            int results = soSmsService.verifySms(identifier, SmsModel.SMS_TYPE_REGISTER, vcode);
////            int results = 1;
//            String vmsg;
//            if (results == 1) {
//            	vmsg = null;
//    		}else if(results == -1){
//    			vmsg="验证码已过期";
//    		}else {
//    			vmsg="手机号码或验证码错误";
//    		}
//            if (vmsg != null) {
//                Map ret = new LinkedHashMap();
//                ret.put("success", false);
//                ret.put("msg", vmsg);
//                return ret;
//            }
//            Map invitor = null;
//            if (!StringUtil.isEmpty(invitationCode)) {
//                invitor = mybatisService.queryRec("usr.queryUserByInvitation", invitationCode);
//                if (invitor == null) {
//                    Map ret = new LinkedHashMap();
//                    ret.put("success", false);
//                    ret.put("msg", "邀请人不存在");
//                    return ret;
//                }
//            }
////
//            Map<String, Object> params = new HashMap<>();
//            params.put("identifier", identifier);
//            params.put("identity_type", identityType);
//            Map old = mybatisService.queryRec("usr.queryUserAuthorizeByIdentifer", params);
//            if (old != null) {
//                Map ret = new LinkedHashMap();
//                ret.put("success", false);
//                ret.put("msg", "该账号已被注册");
//                return ret;
//            }
//
//            long userId = dbService.insert(SqlUtil.buildInsertSqlMap("so_user", new Object[][]{
//                {"phone", identityType.equals("phone") ? identifier : ""},
//                {"invitation_code", randomInvitationCode(6)},
//                {"level", 0},
//                {"create_date", new Date()},
//                {"regist_date", new Date()}
//            }));
//            String uuid = UUID.randomUUID().toString().replaceAll( "-", "" );
//            dbService.insert(SqlUtil.buildInsertSqlMap("so_user_authorized", new Object[][]{
//                {"user_id", userId},
//                {"uuid", uuid},
//                {"identity_type", "phone"},
//                {"identifier", identifier},
//                {"credential", credential},
//                {"regist_date", new Date()},
//                {"regist_ip", ServletUtils.getIpAddress(request)},
//                {"register_client", regClient},
//                {"register_addr", registerAddr},
//                {"create_date", new Date()},
//                {"register_coordinate", registerCoordinate}
//            }));
//
//            Map integralRule = dbService.queryRec("select id, integral from so_integral_rule where function_id=?",
//                    1);
//            if (integralRule == null) {
//                Map ret = new LinkedHashMap();
//                ret.put("success", false);
//                ret.put("msg", "积分规则不存在");
//                return ret;
//            }
//            //初始化用户积分表
//            dbService.insert(SqlUtil.buildInsertSqlMap("so_user_integral", new Object[][]{
//                    {"user_id", userId},
//                    {"integral_level_id", 1},
//                    {"total_integral", integralRule.get("integral")},
//                    {"current_integral", integralRule.get("integral")},
//                    {"sys_user_id", -1},
//                    {"create_time", new Date()},
//                    {"modify_user_id",-1},
//            }));
//            //初始化用户积分记录表
//            dbService.insert(SqlUtil.buildInsertSqlMap("so_user_integral_records", new Object[][]{
//                    {"user_id", userId},
//                    {"integral_rule_id", integralRule.get("id")},
//                    {"integral", integralRule.get("integral")},
//                    {"create_time", new Date()}
//            }));
//
//            //初始化用户账户表
//            dbService.insert(SqlUtil.buildInsertSqlMap("so_user_account", new Object[][]{
//                    {"user_id", userId},
//                    {"account_type", 1},
//                    {"create_time", new Date()}
//            }));
//            //初始化用户认证表
//            dbService.insert(SqlUtil.buildInsertSqlMap("so_user_auth", new Object[][]{
//                    {"user_id", userId},
//                    {"id_state", "10"},
//                    {"bank_card_state", "10"}
//            }));
//
//            if (invitor != null) {
//                dbService.insert(SqlUtil.buildInsertSqlMap("so_user_invite", new Object[][]{
//                    {"invite_time", new Date()},
//                    {"invite_id", userId},
//                    {"invite_name", identifier},
//                    {"user_id", invitor.get("id")},
//                }));
//            }
//
//            //2017.5.6 仅用于demo演示环境
//            demoUser(userId);
//
//            Map result = new LinkedHashMap();
//            result.put("success", true);
//            result.put("msg", "注册成功");
//            return result;
//        } catch (Exception e) {
//            logger.error("注册失败", e);
//            Map ret = new LinkedHashMap();
//            ret.put("success", false);
//            ret.put("msg", "注册失败");
//            return ret;
//        }
//    }
//	/**
//	 * 给注册用户添加芝麻和银行卡演示数据
//	 * @param userId
//	 */
//	private void demoUser(long userId){
//        if(StringUtil.isNotBlank(Global.getValue("app_register_demo"))&&Global.getValue("app_register_demo").equals("1")){
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("bankCardState", "30");
//			map.put("zhimaState", "30");
//			map.put("phoneState", "30");
//			map.put("userId", userId);
////			userAuthService.updateByUserId(map);
//			BankCard card = new BankCard();
//			card.setCardNo("6212261202001978888");
//			card.setBindTime(DateUtil.getNow());
//			card.setUserId(userId);
//			card.setBank("中国农业银行");
//			card.setAgreeNo(OrderNoUtil.getSerialNumber());
////		    bankCardService.save(card);
//
//		    OperatorReqLog  record=new OperatorReqLog();
//		    record.setUserId(userId);
//		    record.setCreateTime(new Date());
//		    record.setRespCode("200");
//		    record.setOrderNo(OrderNoUtil.getSerialNumber());
//		    record.setRespOrderNo(OrderNoUtil.getSerialNumber());
//		    record.setRespTime(new Date());
//		    record.setRespParams("");
////		    operatorReqLogService.insert(record);
//
//		}
//
//	}
//
//
//    private String randomInvitationCode(int len) {
//        while (true) {
//            String str = randomNumAlph(len);
//            if (mybatisService.queryRec("usr.queryUserByInvitation", str) == null) {
//                return str;
//            }
//        }
//    }
//
//    private static String randomNumAlph(int len) {
//        Random random = new Random();
//
//        StringBuilder sb = new StringBuilder();
//        byte[][] list = {
//            {48, 57},
//            {97, 122},
//            {65, 90}
//        };
//        for (int i = 0; i < len; i++) {
//            byte[] o = list[random.nextInt(list.length)];
//            byte value = (byte) (random.nextInt(o[1] - o[0] + 1) + o[0]);
//            sb.append((char) value);
//        }
//        return sb.toString();
//    }
//
//
//    public Object forgetPwd(String phone, String newPwd, String vcode,String signMsg) {
//
//            if (!StringUtil.isEmpty(vcode)) {
//                String msg = smsService.validateSmsCode(phone, SmsModel.SMS_TYPE_FINDREG , vcode);
//                if (msg != null) {
//                    Map ret = new LinkedHashMap();
//                    ret.put("success", false);
//                    ret.put("msg", msg);
//                    return ret;
//                }
//            }
//
//
//            if (dbService.update(SqlUtil.buildUpdateSql("cl_user", MapUtil.array2Map(new Object[][]{
//                {"login_name", phone},
//                {"login_pwd", newPwd},
//                {"loginpwd_modify_time", new Date()}
//            }), "login_name")) == 1) {
//                Map ret = new LinkedHashMap();
//                ret.put("success", true);
//                ret.put("msg", "密码已修改");
//                return ret;
//            } else {
//                Map ret = new LinkedHashMap();
//                ret.put("success", false);
//                ret.put("msg", "密码修改失败");
//                return ret;
//            }
//
//    }
//
//    public Map login(final HttpServletRequest request, final HttpServletResponse response, final String identifier,
//                     final String credential, String
//            identityType) {
//        try {
//            logger.info("账户 identifer = " + identifier + "，类型 identity_type = " + identityType);
//        	Map<String,Object> params = new HashMap<>();
//        	params.put("identifier", identifier);
//        	params.put("identity_type", identityType);
//            Map user = mybatisService.queryRec("usr.queryUserAuthorizeByIdentifer", params);
//            if (user == null) {
//                Map ret = new LinkedHashMap();
//                ret.put("success", false);
//                ret.put("msg", "账户不存在");
//                return ret;
//            }
//
//            String dbPwd = (String) user.get("credential");
//            if (dbPwd.equalsIgnoreCase(credential)) {
//                AppSessionBean session = appDbSession.create(request, identifier, identityType);
//
//                soUserAuthorizedService.modify(identifier, identityType);//修改登陆时间
//                Map ret = new LinkedHashMap();
//                ret.put("success", true);
//                ret.put("msg", "登录成功");
//                ret.put("data", session.getFront());
//
//                Cookie userCookie = new Cookie("userdata", JSON.toJSON(session.getFront()).toString());
//                userCookie.setMaxAge(30*24*60*60);
//                userCookie.setPath("/");
//                response.addCookie( userCookie );
//                return ret;
//            }
//            Map ret = new LinkedHashMap();
//            ret.put("success", false);
//            ret.put("msg", "密码错误");
//            return ret;
//        } catch (Exception e) {
//            logger.error("登录异常", e);
//            Map ret = new LinkedHashMap();
//            ret.put("code", 500);
//            ret.put("msg", "系统异常");
//            return ret;
//        }
//    }
//
//
//}