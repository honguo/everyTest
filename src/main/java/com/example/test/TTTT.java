package com.example.test;

import com.alibaba.fastjson.JSONObject;
import com.caucho.hessian.client.HessianProxyFactory;
import com.google.gson.JsonObject;
import com.yeepay.g3.facade.hermes.dto.CredentialsAuthParam;
import com.yeepay.g3.facade.hermes.dto.CredentialsValidateResultDTO;
import com.yeepay.g3.facade.hermes.facade.CredentialsFacade;
import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.boot.SpringApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

public class TTTT {


    private static String mm = "/rest/v2.0/hbird/dept/info/sync\t158062\n"+
            "/rest/v2.0/hbird/upgrade/version\t129492\n"+
            "/rest/v3.0/hbird/app-boot/boot-page\t104777\n"+
            "/rest/v2.0/hbird/dept/changes\t98837\n"+
            "/rest/v3.0/hbird/user/info/sync\t92249\n"+
            "/rest/v2.0/hbird/config/heart-beat\t90545\n"+
            "/rest/v2.0/hbird/user-query/query\t75688\n"+
            "/rest/v1.0/hbird/group-mgr/find-goups-by-user-id\t74484\n"+
            "/rest/v2.0/hbird/corp/query\t67198\n"+
            "/rest/v2.0/hbird/oauth2/token\t52649\n"+
            "/rest/v1.0/hbird/voip/call-log-incremental\t47514\n"+
            "/rest/v1.0/hbird/user-mgr/validateprincipal\t45450\n"+
            "/rest/v2.0/hbird/user-mgr/check-user\t38383\n"+
            "/rest/v1.0/hbird/welfare/blessings/start-pages\t37777\n"+
            "/rest/v1.0/hbird/meetings/query-room-by-param\t35273\n"+
            "/rest/v2.0/hbird/hbird-auth/auth2\t30771\n"+
            "/rest/v2.0/hbird/user-mgr/user-info\t30036\n"+
            "/rest/v1.0/hbird/user/detail\t26336\n"+
            "/rest/v1.0/hbird/hermes/validate-opening-status\t20427\n"+
            "/rest/v1.0/hbird/hermes/get-credentials\t20173\n"+
            "/rest/v2.0/hbird/oauth2/refresh\t19272\n"+
            "/rest/v2.0/hbird/upgrade-usage/record\t16600\n"+
            "/rest/v1.0/hbird/weex/allportals\t13834\n"+
            "/rest/v1.0/hbird/weex/user_portals\t13824\n"+
            "/rest/v2.0/hbird/meetings/query\t13720\n"+
            "/rest/v1.0/hbird/welfare/register/get-top-theree\t13179\n"+
            "/rest/v1.0/hbird/wifi/wifinames\t11984\n"+
            "/rest/v1.0/hbird/welfare/project/query-user-pros\t9463\n"+
            "/rest/v2.0/hbird/event/feedback\t9389\n"+
            "/rest/v1.0/hbird/welfare/project/get-register-detail\t8824\n"+
            "/rest/v2.0/hbird/user-auth/ldap-authenticate\t8781\n"+
            "/rest/v3.0/hbird/oauth2/group/find-with-users\t8548\n"+
            "/rest/v2.0/hbird/user-mgr/search\t8375\n"+
            "/rest/v1.0/hbird/auth/hbird-token\t7743\n"+
            "/rest/v1.0/hbird/meetings/meeting-room-query-list\t6256\n"+
            "/rest/v1.0/hbird/meetings/query-room\t6033\n"+
            "/rest/v1.0/hbird/welfare/resource-category/list\t5539\n"+
            "/rest/v1.0/hbird/meetings/query-meeting-info\t5081\n"+
            "/rest/v1.0/hbird/staff-comm/attach/download\t4061\n"+
            "/rest/v1.0/hbird/welfare/file/download\t3732\n"+
            "/rest/v1.0/hbird/welfare/attach/downLoad\t3638\n"+
            "/rest/v3.0/hbird/oauth2/token\t2700\n"+
            "/rest/v1.0/hbird/file/down\t2569\n"+
            "/rest/v1.0/hbird/user-query/query\t2551\n"+
            "/rest/v1.0/hbird/user-mgr/query\t2494\n"+
            "/rest/v1.0/hbird/meetings/save\t2377\n"+
            "/rest/v2.0/hbird/user-mgr/work-card\t2303\n"+
            "/rest/v1.0/hbird/meeting/detail-file\t2192\n"+
            "/rest/v1.0/hbird/meetings/update\t2057\n"+
            "/rest/v1.0/hbird/wifi/scan-wifi-qr\t1789\n"+
            "/rest/v1.0/hbird/welfare/wow/index\t1745\n"+
            "/rest/v1.0/hbird/wifi/auth-wifi-qr\t1368\n"+
            "/rest/v1.0/hbird/welfare/business-list\t1249\n"+
            "/rest/v1.0/hbird/user/search/usersAndGroups\t1241\n"+
            "/rest/v1.0/hbird/register/user-register\t1148\n"+
            "/rest/v2.1/hbird/dept/query-structure\t1120\n"+
            "/rest/v1.0/hbird/group/simple-info\t1082\n"+
            "/rest/v2.0/hbird/magic-cube/material-list\t990\n"+
            "/rest/v1.0/hbird/auth/user/baseinfo\t973\n"+
            "/rest/v1.0/hbird/wifi/get-wifi-auth-params\t963\n"+
            "/rest/v1.0/hbird/late-report/user_late_index\t773\n"+
            "/rest/v1.0/hbird/staff-comm/moment/list\t736\n"+
            "/rest/v1.0/hbird/welfare/resource-detail\t729\n"+
            "/rest/v1.0/hbird/late-report/user_late_list\t678\n"+
            "/rest/v1.0/hbird/annc/get-annc-list-for-app\t633\n"+
            "/rest/v1.0/hbird/staff-comm/comment/list\t612\n"+
            "/rest/v1.0/hbird/late-report/is_admin\t605\n"+
            "/rest/v1.0/hbird/annc-file/get-file-by-url\t597\n"+
            "/rest/v2.0/hbird/qr/create-qr\t557\n"+
            "/rest/v1.0/hbird/welfare/blessings/list\t544\n"+
            "/rest/v1.0/hbird/staff-comm/topic/listHot\t523\n"+
            "/rest/v1.0/hbird/meetings/cancel\t510\n"+
            "/rest/v2.0/hbird/sharefile/download\t485\n"+
            "/rest/v1.0/hbird/annc/file/download\t452\n"+
            "/rest/v1.0/hbird/welfare/register/get-rankings\t416\n"+
            "/rest/v1.0/hbird/dynamic-form-client/published_forms\t412\n"+
            "/rest/v1.0/hbird/welfare/label-list\t384\n"+
            "/rest/v2.0/hbird/authentic/user-device\t340\n"+
            "/rest/v2.0/hbird/staff-comm/published/list\t325\n"+
            "/rest/v2.0/hbird/share-file/download\t321\n"+
            "/rest/v1.0/hbird/welfare/wow/detail\t310\n"+
            "/rest/v1.0/hbird/welfare/wow/rank\t305\n"+
            "/rest/v1.0/hbird/staff-comm/moment/detail\t276\n"+
            "/rest/v2.0/hbird/magic-cube/user-list\t253\n"+
            "/rest/v2.0/hbird/qr/scan-qr\t249\n"+
            "/rest/v2.0/hbird/share-file/upload\t246\n"+
            "/rest/v1.0/hbird/user-mgr/send-sms-code-login\t241\n"+
            "/rest/v1.0/hbird/user-mgr/auth-again\t235\n"+
            "/rest/v1.0/hbird/meetings/save-person\t235\n"+
            "/rest/v2.0/hbird/magic-cube/material-download\t232\n"+
            "/rest/v1.0/hbird/annc/detailedInfo\t223\n"+
            "/rest/v2.0/hbird/qr/login-qr\t215\n"+
            "/rest/v1.0/hbird/welfare/wow/merge-info\t211\n"+
            "/rest/v1.0/hbird/register/cancel-register\t210\n"+
            "/rest/v2.0/hbird/meeting/audit/query\t206\n"+
            "/rest/v1.0/hbird/welfare/wow/submit\t204\n"+
            "/rest/v1.0/hbird/welfare/blessings/detail\t179\n"+
            "/rest/v1.0/hbird/dynamic-form-client/form_detail\t172\n"+
            "/rest/v1.0/hbird/meeting/early-termination\t166\n"+
            "/rest/v1.0/hbird/register/location/list\t160\n"+
            "/rest/v1.0/hbird/wifi-visitor/scan\t159\n"+
            "/rest/v1.0/hbird/annc/update-user-msg-status\t152\n"+
            "/rest/v1.0/hbird/hermes/bind-credentials\t149\n"+
            "/rest/v1.0/hbird/late-report/admin-follow\t138\n"+
            "/rest/v2.0/hbird/voip/call-log\t134\n"+
            "/rest/v1.0/hbird/wifi-visitor/auth\t132\n"+
            "/rest/v1.0/hbird/welfare/wow/exchanges\t128\n"+
            "/rest/v2.0/hbird/user/update-pwd\t124\n"+
            "/rest/v1.0/hbird/late-report/admin-statistics-by-day-count\t117\n"+
            "/rest/v1.0/hbird/late-report/admin-statistics-by-month-count\t117\n"+
            "/rest/v1.0/hbird/weex/save_user_portals\t111\n"+
            "/rest/v2.0/hbird/user/update\t109\n"+
            "/rest/v1.0/hbird/late-report/create\t104\n"+
            "/rest/v1.0/hbird/welfare/blessings/exchange\t97\n"+
            "/rest/v1.0/hbird/welfare/order/exchange-records\t74\n"+
            "/rest/v1.0/hbird/meetings/update-time\t73\n"+
            "/rest/v1.0/hbird/welfare/register/get-rule\t68\n"+
            "/rest/v1.0/hbird/hermes/destory-credentials\t64\n"+
            "/rest/v2.0/hbird/user/info/sync\t57\n"+
            "/rest/v1.0/hbird/late-report/admin-statistics-by-month\t54\n"+
            "/rest/v2.0/hbird/user-mgr/upload-work-card\t48\n"+
            "/rest/v1.0/hbird/staff-comm/comment/create\t46\n"+
            "/rest/v2.0/hbird/meeting/audit/join\t32\n"+
            "/rest/v1.0/hbird/dynamic-form-client/upload\t32\n"+
            "/rest/v2.0/hbird/user-mgr/send-sms-code\t22\n"+
            "/rest/v1.0/hbird/late-report/admin-statistics-by-day\t22\n"+
            "/rest/v1.0/hbird/dynamic-form-client/add_form_data\t20\n"+
            "/rest/v2.0/hbird/user-mgr/modify-user-mobile\t19\n"+
            "/rest/v1.0/hbird/staff-comm/message/list\t19\n"+
            "/rest/v1.0/hbird/staff-comm/attach/upload\t15\n"+
            "/rest/v2.0/hbird/group/quit\t10\n"+
            "/rest/v1.0/hbird/user-device/save\t9\n"+
            "/rest/v1.0/hbird/staff-comm/moment/publish\t9\n"+
            "/rest/v2.0/hbird/group/join\t8\n"+
            "/rest/v1.0/hbird/welfare/wow/exchange\t8\n"+
            "/rest/v2.0/hbird/group/create\t7\n"+
            "/rest/v2.0/hbird/sharefile/query\t7\n"+
            "/rest/v1.0/hbird/staff-comm/topic/list\t7\n"+
            "/rest/v1.0/hbird/staff-comm/comment/update\t6\n"+
            "/rest/v1.0/hbird/meetings/delete-person\t6\n"+
            "/rest/v1.0/hbird/group/isExist\t6\n"+
            "/rest/v2.0/hbird/user/query-row\t6\n"+
            "/rest/v1.0/hbird/group/qrCode\t6\n"+
            "/rest/v1.0/hbird/staff-comm/moment/delete\t5\n"+
            "/rest/v2.0/hbird/user/feedback\t4\n"+
            "/rest/v2.0/hbird/user-mgr/query-user\t4\n"+
            "/rest/v2.0/hbird/user-mgr/web-upload-avatar\t4\n"+
            "/rest/v2.0/hbird/dept/query\t3\n"+
            "/rest/v1.0/hbird/group/ungroup\t3\n"+
            "/rest/v2.0/hbird/oauth2/group/find-with-users\t3\n"+
            "/rest/v1.0/hbird/user-device/unbunding-dev\t3\n"+
            "/rest/v2.0/hbird/app-boot/boot-page\t3\n"+
            "/rest/v2.0/hbird/meeting/audit/quit\t3\n"+
            "/rest/v1.0/hbird/meetings/update-content\t3\n"+
            "/rest/v2.0/hbird/group/update\t3\n"+
            "/rest/v1.0/hbird/group/transfer\t1\n"+
            "/rest/v1.0/hbird/auth2/auth-enterprise\t1\n";

    private static String all = "/rest/v1.0/hbird/annc/get-annc-for-app\tcom.yeepay.g3.facade.announcement.facade.AnncFacade\n" +
            "/rest/v1.0/hbird/annc/detailedInfo\tcom.yeepay.g3.facade.announcement.facade.AnncFacade\n" +
            "/rest/v1.0/hbird/annc/update-user-msg-status\tcom.yeepay.g3.facade.announcement.facade.AnncFacade\n" +
            "/rest/v1.0/hbird/annc/get-annc-list-for-app\tcom.yeepay.g3.facade.announcement.facade.AnncFacade\n" +
            "/rest/v1.0/hbird/annc-file/get-file-by-url\tcom.yeepay.g3.facade.announcement.facade.AnncFileFacade\n" +
            "/rest/v1.0/hbird/annc/file/download\tcom.yeepay.g3.facade.announcement.facade.AnncFileFacade\n" +
            "/rest/v1.0/hbird/annc-type/query\tcom.yeepay.g3.facade.announcement.facade.AnncTypeFacade\n" +
            "/rest/v1.0/hbird/annc-type/query-for-app\tcom.yeepay.g3.facade.announcement.facade.AnncTypeFacade\n" +
            "/rest/v1.0/hbird/auth2/auth-enterprise\tcom.yeepay.g3.facade.auth2.facade.Auth2Facade\n" +
            "/rest/v2.0/hbird/meeting/audit/quit\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingAuditFacade\n" +
            "/rest/v2.0/hbird/meeting/audit/query\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingAuditFacade\n" +
            "/rest/v2.0/hbird/meeting/audit/join\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingAuditFacade\n" +
            "/rest/v1.0/hbird/meetings/delete\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingFileFacade\n" +
            "/rest/v1.0/hbird/meetings/download-file\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingFileFacade\n" +
            "/rest/v1.0/hbird/meetings/save-file\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingFileFacade\n" +
            "/rest/v1.0/hbird/meetings/get-file-by-meeting-id\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingFileFacade\n" +
            "/rest/v1.0/hbird/meetings/modify-end-status\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingMgrFacade\n" +
            "/rest/v1.0/hbird/meetings/update-time\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingMgrFacade\n" +
            "/rest/v1.0/hbird/meetings/update-content\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingMgrFacade\n" +
            "/rest/v1.0/hbird/meeting/early-termination\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingMgrFacade\n" +
            "/rest/v1.0/hbird/meetings/save-person\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingMgrFacade\n" +
            "/rest/v1.0/hbird/meetings/delete-person\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingMgrFacade\n" +
            "/rest/v1.0/hbird/meetings/update\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingMgrFacade\n" +
            "/rest/v1.0/hbird/meetings/cancel\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingMgrFacade\n" +
            "/rest/v1.0/hbird/meetings/save\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingMgrFacade\n" +
            "/rest/v1.0/hbird/meetings/modify-edit-status\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingMgrFacade\n" +
            "/rest/v1.0/hbird/meetings/get-persons-by-meeting-id\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingQueryFacade\n" +
            "/rest/v2.0/hbird/meetings/query\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingQueryFacade\n" +
            "/rest/v1.0/hbird/meeting/detail-file\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingQueryFacade\n" +
            "/rest/v1.0/hbird/meetings/query-meeting-info\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingQueryFacade\n" +
            "/rest/v1.0/hbird/meetings/query\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingQueryFacade\n" +
            "/rest/v1.0/hbird/meetings/query-room\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingRoomLocationFacade\n" +
            "/rest/v1.0/hbird/meetings/meeting-room-query-list\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingRoomQueryFacade\n" +
            "/rest/v1.0/hbird/meetings/query-room-list-by-param\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingRoomQueryFacade\n" +
            "/rest/v1.0/hbird/meetings/query-room-by-param\tcom.yeepay.g3.facade.bundle.meeting.facade.MeetingRoomQueryFacade\n" +
            "/rest/v2.0/hbird/app-boot/boot-page\tcom.yeepay.g3.facade.hbird.facade.AppBootFacade\n" +
            "/rest/v3.0/hbird/app-boot/boot-page\tcom.yeepay.g3.facade.hbird.facade.AppBootFacade\n" +
            "/rest/v2.0/hbird/app-boot/save-or-update\tcom.yeepay.g3.facade.hbird.facade.AppBootFacade\n" +
            "/rest/v2.0/hbird/config/heart-beat\tcom.yeepay.g3.facade.hbird.facade.ConfigFacade\n" +
            "/rest/v1.0/hbird/conversation/set-mute\tcom.yeepay.g3.facade.hbird.facade.ConversationFacade\n" +
            "/rest/v1.0/hbird/conversation/get-mute\tcom.yeepay.g3.facade.hbird.facade.ConversationFacade\n" +
            "/rest/v2.0/hbird/corp/query\tcom.yeepay.g3.facade.hbird.facade.CorpQueryFacade\n" +
            "/rest/v2.0/hbird/dept/update\tcom.yeepay.g3.facade.hbird.facade.DeptMgrFacade\n" +
            "/rest/v2.0/hbird/dept/query\tcom.yeepay.g3.facade.hbird.facade.DeptQueryFacade\n" +
            "/rest/v2.1/hbird/dept/query-structure\tcom.yeepay.g3.facade.hbird.facade.DeptQueryFacade\n" +
            "/rest/v1.0/hbird/dept/query-structure\tcom.yeepay.g3.facade.hbird.facade.DeptQueryFacade\n" +
            "/rest/v1.0/hbird/dept-query/query-structure\tcom.yeepay.g3.facade.hbird.facade.DeptQueryFacade\n" +
            "/rest/v2.0/hbird/dept/changes\tcom.yeepay.g3.facade.hbird.facade.DeptSyncFacade\n" +
            "/rest/v3.0/hbird/user/info/sync\tcom.yeepay.g3.facade.hbird.facade.DeptSyncFacade\n" +
            "/rest/v2.0/hbird/user/info/sync\tcom.yeepay.g3.facade.hbird.facade.DeptSyncFacade\n" +
            "/rest/v2.0/hbird/dept/info/sync\tcom.yeepay.g3.facade.hbird.facade.DeptSyncFacade\n" +
            "/rest/v1.0/hbird/dynamic-form-client/published_forms\tcom.yeepay.g3.facade.hbird.facade.DynamicFormClientFacade\n" +
            "/rest/v1.0/hbird/dynamic-form-client/upload\tcom.yeepay.g3.facade.hbird.facade.DynamicFormClientFacade\n" +
            "/rest/v1.0/hbird/dynamic-form-client/add_form_data\tcom.yeepay.g3.facade.hbird.facade.DynamicFormClientFacade\n" +
            "/rest/v1.0/hbird/dynamic-form-client/form_detail\tcom.yeepay.g3.facade.hbird.facade.DynamicFormClientFacade\n" +
            "/rest/v2.0/hbird/event/feedback\tcom.yeepay.g3.facade.hbird.facade.EventFacade\n" +
            "/rest/v1.0/hbird/file/down\tcom.yeepay.g3.facade.hbird.facade.FileInfoFacade\n" +
            "/rest/v2.0/hbird/oauth2/group/find-with-users\tcom.yeepay.g3.facade.hbird.facade.GroupMgrFacade\n" +
            "/rest/v3.0/hbird/oauth2/group/find-with-users\tcom.yeepay.g3.facade.hbird.facade.GroupMgrFacade\n" +
            "/rest/v1.0/hbird/group/simple-info\tcom.yeepay.g3.facade.hbird.facade.GroupMgrFacade\n" +
            "/rest/v2.0/hbird/group/simple-info\tcom.yeepay.g3.facade.hbird.facade.GroupMgrFacade\n" +
            "/rest/v1.0/hbird/group/isExist\tcom.yeepay.g3.facade.hbird.facade.GroupMgrFacade\n" +
            "/rest/v1.0/hbird/group/qrCode\tcom.yeepay.g3.facade.hbird.facade.GroupMgrFacade\n" +
            "/rest/v1.0/hbird/group/remark\tcom.yeepay.g3.facade.hbird.facade.GroupMgrFacade\n" +
            "/rest/v1.0/hbird/group/transfer\tcom.yeepay.g3.facade.hbird.facade.GroupMgrFacade\n" +
            "/rest/v1.0/hbird/group-mgr/find-goups-by-user-id\tcom.yeepay.g3.facade.hbird.facade.GroupMgrFacade\n" +
            "/rest/v1.0/hbird/group/ungroup\tcom.yeepay.g3.facade.hbird.facade.GroupMgrFacade\n" +
            "/rest/v2.0/hbird/group/kickout\tcom.yeepay.g3.facade.hbird.facade.GroupMgrFacade\n" +
            "/rest/v2.0/hbird/group/join\tcom.yeepay.g3.facade.hbird.facade.GroupMgrFacade\n" +
            "/rest/v2.0/hbird/group/create\tcom.yeepay.g3.facade.hbird.facade.GroupMgrFacade\n" +
            "/rest/v2.0/hbird/group/find\tcom.yeepay.g3.facade.hbird.facade.GroupMgrFacade\n" +
            "/rest/v2.0/hbird/group/update\tcom.yeepay.g3.facade.hbird.facade.GroupMgrFacade\n" +
            "/rest/v2.0/hbird/group/quit\tcom.yeepay.g3.facade.hbird.facade.GroupMgrFacade\n" +
            "/rest/v2.0/hbird/oauth2/refresh\tcom.yeepay.g3.facade.hbird.facade.HbirdAuthFacade\n" +
            "/rest/v1.0/hbird/auth/hbird-token\tcom.yeepay.g3.facade.hbird.facade.HbirdAuthFacade\n" +
            "/rest/v2.0/hbird/hbird-auth/auth2\tcom.yeepay.g3.facade.hbird.facade.HbirdAuthFacade\n" +
            "/rest/v1.0/hbird/jour/jour-data\tcom.yeepay.g3.facade.hbird.facade.HbirdJourFacade\n" +
            "/rest/v1.0/hbird/message/receipt\tcom.yeepay.g3.facade.hbird.facade.HbirdMessageFacade\n" +
            "/rest/v1.0/hbird/hermes/destory-credentials\tcom.yeepay.g3.facade.hbird.facade.HermesFacade\n" +
            "/rest/v1.0/hbird/hermes/validate-user-and-device\tcom.yeepay.g3.facade.hbird.facade.HermesFacade\n" +
            "/rest/v1.0/hbird/hermes/validate-device\tcom.yeepay.g3.facade.hbird.facade.HermesFacade\n" +
            "/rest/v1.0/hbird/hermes/bind-credentials\tcom.yeepay.g3.facade.hbird.facade.HermesFacade\n" +
            "/rest/v1.0/hbird/hermes/validate-opening-status\tcom.yeepay.g3.facade.hbird.facade.HermesFacade\n" +
            "/rest/v1.0/hbird/hermes/get-credentials\tcom.yeepay.g3.facade.hbird.facade.HermesFacade\n" +
            "/rest/v1.0/hbird/late-report/create\tcom.yeepay.g3.facade.hbird.facade.LateReportFacade\n" +
            "/rest/v1.0/hbird/late-report/admin-statistics-by-month\tcom.yeepay.g3.facade.hbird.facade.LateReportFacade\n" +
            "/rest/v1.0/hbird/late-report/admin-statistics-by-month-count\tcom.yeepay.g3.facade.hbird.facade.LateReportFacade\n" +
            "/rest/v1.0/hbird/late-report/user_late_index\tcom.yeepay.g3.facade.hbird.facade.LateReportFacade\n" +
            "/rest/v1.0/hbird/late-report/user_late_list\tcom.yeepay.g3.facade.hbird.facade.LateReportFacade\n" +
            "/rest/v1.0/hbird/late-report/is_admin\tcom.yeepay.g3.facade.hbird.facade.LateReportFacade\n" +
            "/rest/v1.0/hbird/late-report/admin-statistics-by-day\tcom.yeepay.g3.facade.hbird.facade.LateReportFacade\n" +
            "/rest/v1.0/hbird/late-report/admin-statistics-by-day-count\tcom.yeepay.g3.facade.hbird.facade.LateReportFacade\n" +
            "/rest/v1.0/hbird/late-report/admin-follow\tcom.yeepay.g3.facade.hbird.facade.LateReportFacade\n" +
            "/rest/v1.0/hbird/message/send-private-img-text-message\tcom.yeepay.g3.facade.hbird.facade.MessageFacade\n" +
            "/rest/v2.0/hbird/qr/login-qr\tcom.yeepay.g3.facade.hbird.facade.QrFacade\n" +
            "/rest/v2.0/hbird/qr/create-qr\tcom.yeepay.g3.facade.hbird.facade.QrFacade\n" +
            "/rest/v2.0/hbird/qr/scan-qr\tcom.yeepay.g3.facade.hbird.facade.QrFacade\n" +
            "/rest/v2.0/hbird/sharefile/query\tcom.yeepay.g3.facade.hbird.facade.ShareFileFacade\n" +
            "/rest/v1.0/hbird/sharefile/search\tcom.yeepay.g3.facade.hbird.facade.ShareFileFacade\n" +
            "/rest/v2.0/hbird/share-file/download\tcom.yeepay.g3.facade.hbird.facade.ShareFileFacade\n" +
            "/rest/v2.0/hbird/share-file/upload\tcom.yeepay.g3.facade.hbird.facade.ShareFileFacade\n" +
            "/rest/v1.0/hbird/share-file/delete-by-file-id\tcom.yeepay.g3.facade.hbird.facade.ShareFileFacade\n" +
            "/rest/v2.0/hbird/sharefile/upload\tcom.yeepay.g3.facade.hbird.facade.ShareFileFacade\n" +
            "/rest/v2.0/hbird/sharefile/download\tcom.yeepay.g3.facade.hbird.facade.ShareFileFacade\n" +
            "/rest/v2.0/hbird/upgrade-usage/record\tcom.yeepay.g3.facade.hbird.facade.UpgradeUsageFacade\n" +
            "/rest/v2.0/hbird/upgrade/version\tcom.yeepay.g3.facade.hbird.facade.UpgradeVersionFacade\n" +
            "/rest/v2.0/hbird/upgrade-version/save-or-update-for-task\tcom.yeepay.g3.facade.hbird.facade.UpgradeVersionFacade\n" +
            "/rest/v2.0/hbird/upgrade-version/save-or-update\tcom.yeepay.g3.facade.hbird.facade.UpgradeVersionFacade\n" +
            "/rest/v2.0/hbird/oauth2/token\tcom.yeepay.g3.facade.hbird.facade.UserAuthFacade\n" +
            "/rest/v3.0/hbird/oauth2/token\tcom.yeepay.g3.facade.hbird.facade.UserAuthFacade\n" +
            "/rest/v1.0/hbird/auth/user/baseinfo\tcom.yeepay.g3.facade.hbird.facade.UserAuthFacade\n" +
            "/rest/v2.0/hbird/user-auth/ldap-authenticate\tcom.yeepay.g3.facade.hbird.facade.UserAuthFacade\n" +
            "/rest/v2.0/hbird/user/update-pwd\tcom.yeepay.g3.facade.hbird.facade.UserAuthFacade\n" +
            "/rest/v1.0/hbird/user-device/unbunding-dev\tcom.yeepay.g3.facade.hbird.facade.UserDeviceFacade\n" +
            "/rest/v1.0/hbird/user-device/save\tcom.yeepay.g3.facade.hbird.facade.UserDeviceFacade\n" +
            "/rest/v2.0/hbird/authentic/user-device\tcom.yeepay.g3.facade.hbird.facade.UserDeviceFacade\n" +
            "/rest/v1.0/hbird/authentic/user-device\tcom.yeepay.g3.facade.hbird.facade.UserDeviceFacade\n" +
            "/rest/v1.0/hbird/user-mgr/validateprincipal\tcom.yeepay.g3.facade.hbird.facade.UserMgrFacade\n" +
            "/rest/v1.0/hbird/user-mgr/send-sms-code-login\tcom.yeepay.g3.facade.hbird.facade.UserMgrFacade\n" +
            "/rest/v1.0/hbird/user-mgr/auth-again\tcom.yeepay.g3.facade.hbird.facade.UserMgrFacade\n" +
            "/rest/v2.0/hbird/user-mgr/query-user\tcom.yeepay.g3.facade.hbird.facade.UserMgrFacade\n" +
            "/rest/v1.0/hbird/user-mgr/query\tcom.yeepay.g3.facade.hbird.facade.UserMgrFacade\n" +
            "/rest/v2.0/hbird/user-mgr/check-user\tcom.yeepay.g3.facade.hbird.facade.UserMgrFacade\n" +
            "/rest/v2.0/hbird/user-mgr/search\tcom.yeepay.g3.facade.hbird.facade.UserMgrFacade\n" +
            "/rest/v2.0/hbird/user-mgr/user-info\tcom.yeepay.g3.facade.hbird.facade.UserMgrFacade\n" +
            "/rest/v2.0/hbird/user-mgr/web-upload-work-card\tcom.yeepay.g3.facade.hbird.facade.UserMgrFacade\n" +
            "/rest/v2.0/hbird/user-mgr/web-upload-avatar\tcom.yeepay.g3.facade.hbird.facade.UserMgrFacade\n" +
            "/rest/v2.0/hbird/user-mgr/create\tcom.yeepay.g3.facade.hbird.facade.UserMgrFacade\n" +
            "/rest/v2.0/hbird/user/update\tcom.yeepay.g3.facade.hbird.facade.UserMgrFacade\n" +
            "/rest/v2.0/hbird/user-mgr/send-sms-code\tcom.yeepay.g3.facade.hbird.facade.UserMgrFacade\n" +
            "/rest/v2.0/hbird/user-mgr/modify-user-mobile\tcom.yeepay.g3.facade.hbird.facade.UserMgrFacade\n" +
            "/rest/v2.0/hbird/user-mgr/upload-work-card\tcom.yeepay.g3.facade.hbird.facade.UserMgrFacade\n" +
            "/rest/v2.0/hbird/user-mgr/work-card\tcom.yeepay.g3.facade.hbird.facade.UserMgrFacade\n" +
            "/rest/v2.0/hbird/user/feedback\tcom.yeepay.g3.facade.hbird.facade.UserMgrFacade\n" +
            "/rest/v2.0/hbird/user/query-row\tcom.yeepay.g3.facade.hbird.facade.UserQueryFacade\n" +
            "/rest/v1.0/hbird/user/simple\tcom.yeepay.g3.facade.hbird.facade.UserQueryFacade\n" +
            "/rest/v1.0/hbird/user/detail\tcom.yeepay.g3.facade.hbird.facade.UserQueryFacade\n" +
            "/rest/v2.0/hbird/user-query/query\tcom.yeepay.g3.facade.hbird.facade.UserQueryFacade\n" +
            "/rest/v1.0/hbird/user/search/usersAndGroups\tcom.yeepay.g3.facade.hbird.facade.UserQueryFacade\n" +
            "/rest/v1.0/hbird/user-query/query\tcom.yeepay.g3.facade.hbird.facade.UserQueryFacade\n" +
            "/rest/v1.0/hbird/voip/call-log-incremental\tcom.yeepay.g3.facade.hbird.facade.VoipMgrFacade\n" +
            "/rest/v2.0/hbird/voip/call-log\tcom.yeepay.g3.facade.hbird.facade.VoipMgrFacade\n" +
            "/rest/v1.0/hbird/weex/allportals\tcom.yeepay.g3.facade.hbird.facade.WeexFacade\n" +
            "/rest/v1.0/hbird/weex/save_user_portals\tcom.yeepay.g3.facade.hbird.facade.WeexFacade\n" +
            "/rest/v1.0/hbird/weex/user_portals\tcom.yeepay.g3.facade.hbird.facade.WeexFacade\n" +
            "/rest/v1.0/hbird/wifi/scan-wifi-qr\tcom.yeepay.g3.facade.hbird.facade.WifiFacade\n" +
            "/rest/v1.0/hbird/wifi-visitor/scan\tcom.yeepay.g3.facade.hbird.facade.WifiFacade\n" +
            "/rest/v1.0/hbird/wifi-visitor/auth\tcom.yeepay.g3.facade.hbird.facade.WifiFacade\n" +
            "/rest/v1.0/hbird/wifi/visitor\tcom.yeepay.g3.facade.hbird.facade.WifiFacade\n" +
            "/rest/v1.0/hbird/wifi/wifinames\tcom.yeepay.g3.facade.hbird.facade.WifiFacade\n" +
            "/rest/v1.0/hbird/wifi/del\tcom.yeepay.g3.facade.hbird.facade.WifiFacade\n" +
            "/rest/v1.0/hbird/wifi/get-wifi-auth-params\tcom.yeepay.g3.facade.hbird.facade.WifiFacade\n" +
            "/rest/v1.0/hbird/wifi/auth-wifi-qr\tcom.yeepay.g3.facade.hbird.facade.WifiFacade\n" +
            "/rest/v2.0/hbird/magic-cube/material-list\tcom.yeepay.g3.facade.hbird.sales.helper.facade.MagicCubeMaterialFacade\n" +
            "/rest/v2.0/hbird/magic-cube/material-download\tcom.yeepay.g3.facade.hbird.sales.helper.facade.MagicCubeMaterialFacade\n" +
            "/rest/v1.0/hbird/magic-cube/search\tcom.yeepay.g3.facade.hbird.sales.helper.facade.MagicCubeSearchFacade\n" +
            "/rest/v2.0/hbird/magic-cube/user-list\tcom.yeepay.g3.facade.hbird.sales.helper.facade.MagicCubeUserFacade\n" +
            "/rest/v1.0/hbird/staff-comm/attach/upload\tcom.yeepay.g3.facade.hbird.staff.comm.facade.AttachMgrFacade\n" +
            "/rest/v1.0/hbird/staff-comm/attach/download\tcom.yeepay.g3.facade.hbird.staff.comm.facade.AttachMgrFacade\n" +
            "/rest/v1.0/hbird/staff-comm/comment/update\tcom.yeepay.g3.facade.hbird.staff.comm.facade.CommentMgrFacade\n" +
            "/rest/v1.0/hbird/staff-comm/comment/list\tcom.yeepay.g3.facade.hbird.staff.comm.facade.CommentMgrFacade\n" +
            "/rest/v1.0/hbird/staff-comm/comment/create\tcom.yeepay.g3.facade.hbird.staff.comm.facade.CommentMgrFacade\n" +
            "/rest/v1.0/hbird/staff-comm/message/list\tcom.yeepay.g3.facade.hbird.staff.comm.facade.MessageMgrFacade\n" +
            "/rest/v1.0/hbird/staff-comm/moment/delete\tcom.yeepay.g3.facade.hbird.staff.comm.facade.MomentMgrFacade\n" +
            "/rest/v2.0/hbird/staff-comm/published/list\tcom.yeepay.g3.facade.hbird.staff.comm.facade.MomentMgrFacade\n" +
            "/rest/v1.0/hbird/staff-comm/published/list\tcom.yeepay.g3.facade.hbird.staff.comm.facade.MomentMgrFacade\n" +
            "/rest/v1.0/hbird/staff-comm/moment/publish\tcom.yeepay.g3.facade.hbird.staff.comm.facade.MomentMgrFacade\n" +
            "/rest/v1.0/hbird/staff-comm/moment/list\tcom.yeepay.g3.facade.hbird.staff.comm.facade.MomentMgrFacade\n" +
            "/rest/v1.0/hbird/staff-comm/moment/detail\tcom.yeepay.g3.facade.hbird.staff.comm.facade.MomentMgrFacade\n" +
            "/rest/v1.0/hbird/staff-comm/topic/listHot\tcom.yeepay.g3.facade.hbird.staff.comm.facade.TopicMgrFacade\n" +
            "/rest/v1.0/hbird/staff-comm/topic/list\tcom.yeepay.g3.facade.hbird.staff.comm.facade.TopicMgrFacade\n" +
            "/rest/v1.0/hbird/welfare/blessings/exchange\tcom.yeepay.g3.facade.hbird.welfare.facade.BlessingsFacade\n" +
            "/rest/v1.0/hbird/welfare/blessings/start-pages\tcom.yeepay.g3.facade.hbird.welfare.facade.BlessingsFacade\n" +
            "/rest/v1.0/hbird/welfare/blessings/list\tcom.yeepay.g3.facade.hbird.welfare.facade.BlessingsFacade\n" +
            "/rest/v1.0/hbird/welfare/blessings/detail\tcom.yeepay.g3.facade.hbird.welfare.facade.BlessingsFacade\n" +
            "/rest/v1.0/hbird/exchange/query/list\tcom.yeepay.g3.facade.hbird.welfare.facade.ExchangeProQueryFacade\n" +
            "/rest/v1.0/hbird/welfare/label-list\tcom.yeepay.g3.facade.hbird.welfare.facade.LabelFacade\n" +
            "/rest/v1.0/hbird/welfare/order/exchange-records\tcom.yeepay.g3.facade.hbird.welfare.facade.OrderFacade\n" +
            "/rest/v1.0/hbird/welfare/project/get-register-detail\tcom.yeepay.g3.facade.hbird.welfare.facade.RegisterProQueryFacade\n" +
            "/rest/v1.0/hbird/welfare/project/query-user-pros\tcom.yeepay.g3.facade.hbird.welfare.facade.RegisterProQueryFacade\n" +
            "/rest/v1.0/hbird/welfare/register/get-top-theree\tcom.yeepay.g3.facade.hbird.welfare.facade.RegisterProQueryFacade\n" +
            "/rest/v1.0/hbird/welfare/register/get-rankings\tcom.yeepay.g3.facade.hbird.welfare.facade.RegisterProQueryFacade\n" +
            "/rest/v1.0/hbird/welfare/register/get-rule\tcom.yeepay.g3.facade.hbird.welfare.facade.RegisterProQueryFacade\n" +
            "/rest/v1.0/hbird/welfare/attach/downLoad\tcom.yeepay.g3.facade.hbird.welfare.facade.ResourceAttachFacade\n" +
            "/rest/v1.0/hbird/welfare/resource-category/list\tcom.yeepay.g3.facade.hbird.welfare.facade.ResourceCategoryFacade\n" +
            "/rest/v1.0/hbird/welfare/resource-detail\tcom.yeepay.g3.facade.hbird.welfare.facade.ResourceDetailFacade\n" +
            "/rest/v1.0/hbird/welfare/business-list\tcom.yeepay.g3.facade.hbird.welfare.facade.ResourceDetailFacade\n" +
            "/rest/v1.0/hbird/register/location/list\tcom.yeepay.g3.facade.hbird.welfare.facade.ResourceLocationFacade\n" +
            "/rest/v1.0/hbird/register/cancel-register\tcom.yeepay.g3.facade.hbird.welfare.facade.UserRegisterFacade\n" +
            "/rest/v1.0/hbird/register/user-register\tcom.yeepay.g3.facade.hbird.welfare.facade.UserRegisterFacade\n" +
            "/rest/v1.0/hbird/welfare/file/download\tcom.yeepay.g3.facade.hbird.welfare.facade.WelfareFileFacade\n" +
            "/rest/v1.0/hbird/welfare/wow/merge-info\tcom.yeepay.g3.facade.hbird.welfare.facade.WowCardFacade\n" +
            "/rest/v1.0/hbird/welfare/wow/rank\tcom.yeepay.g3.facade.hbird.welfare.facade.WowCardFacade\n" +
            "/rest/v1.0/hbird/welfare/wow/detail\tcom.yeepay.g3.facade.hbird.welfare.facade.WowCardFacade\n" +
            "/rest/v1.0/hbird/welfare/wow/index\tcom.yeepay.g3.facade.hbird.welfare.facade.WowCardFacade\n" +
            "/rest/v1.0/hbird/welfare/wow/submit\tcom.yeepay.g3.facade.hbird.welfare.facade.WowCardFacade\n" +
            "/rest/v1.0/hbird/welfare/wow/exchange\tcom.yeepay.g3.facade.hbird.welfare.facade.WowCardFacade\n" +
            "/rest/v1.0/hbird/welfare/wow/exchanges\tcom.yeepay.g3.facade.hbird.welfare.facade.WowCardFacade\n" +
            "/rest/v2.0/hbird/oauth2/revoke\tcom.yeepay.g3.facade.yop.oauth2.facade.TokenFacade\n";

    public static void test1() throws Exception {

        HessianProxyFactory proxyFactory = new HessianProxyFactory();
        CredentialsFacade facade = (CredentialsFacade) proxyFactory.create(CredentialsFacade.class, "http://ycetest.yeepay.com:30119/hermes-hessian/hessian/CredentialsFacade");

        for (int i = 0; i < 100; i++) {
            CredentialsAuthParam cap = new CredentialsAuthParam.CredentialsAuthParamBuilder()
                    .setSystemCode("employee-boss")
//                    .setUserId("jipeng.yu@tcredit.com")
                    .setUserId("jiahong.li")
                    .setValidationCode("596821")
                    .setIp("192.168.0.1")
                    .createCredentialsAuthParam();
            CredentialsValidateResultDTO rs = facade.validateCredentials(cap);
            System.out.println(JSONObject.toJSON(rs));
            Thread.sleep(1000L);
        }
    }
    public static void main(String[] args) {
        try {
            test1();
        }catch (Exception e){

//        try
        }{
//            String[] mmlist = mm.split("\n");
//            Map<String,String> map = new HashMap<>();
//            for(String m :mmlist){
//                String[] i = m.split("\t");
//                map.put(i[0],i[1]);
//            }
////            System.out.println(map);
//            String[] allList = all.split("\n");
////            Map<String,String> allmap = new HashMap<>();
////            for(String n :allList){
////                String[] i = n.split("\t");
////                allmap.put(i[0],i[1]);
////            }
//            Map<String ,Map<String,String>> result = new HashMap<>();
//            List<String> re = new ArrayList();
//            for (String n : allList){
//                String[] i = n.split("\t");
//                Map<String,String> nn = new HashMap<>();
//                if(i[0] != null && map.get(i[0]) == null){
//                    re.add(i[0]);
//                }
//                nn.put("访问量",map.get(i[0]));
//                nn.put("facade",i[1]);
//                result.put(i[0],nn);
//            }
//            System.out.println(result);
//            System.out.println(re);
////            Map<String,Map<String,String>> sortMap = new LinkedHashMap<>();
////            new result.entrySet().stream()
////                    .sorted((o1, o2) -> o2.getValue().get("访问量").compareTo(o1.getValue()).get("访问量"))
////                    .forEach(entry -> sortMap.put(entry.getKey(), entry.getValue()));
//            excel(result);
//
//        }catch (Exception e){
//            System.out.println(e);
//        }
    }
//
//    public static void excel(Map<String ,Map<String,String>> result){
//        HSSFWorkbook wb = new HSSFWorkbook();//声明工
//        Sheet sheet = wb.createSheet("yop_hbird_api_访问量");//新建表
//        sheet.setDefaultColumnWidth(15);//设置表宽
//        HSSFCellStyle style = wb.createCellStyle();
//        HSSFFont font = wb.createFont();
//        font.setFontHeightInPoints((short) 12);
//
//        HSSFCellStyle headerStyle = wb.createCellStyle();
//        HSSFFont headerFont = wb.createFont();
//        headerFont.setFontHeightInPoints((short) 14);
//
//        headerStyle.setFont(headerFont);
//
//        CellRangeAddress cra0 = new CellRangeAddress(0, 1, 0, 9);
//        sheet.addMergedRegion(cra0);
//        sheet.setDefaultColumnWidth((short) 15);
//        Row row = sheet.createRow(0);
//        Cell cell1 = row.createCell(0);
//
//        cell1.setCellValue("api访问量表");
//        cell1.setCellStyle(headerStyle);
//        //设置字体样式
//        HSSFFont titleFont = wb.createFont();
//
//        Row row1 = sheet.createRow(2);
//
//        Cell cell = row1.createCell(0);
//        cell.setCellValue("api");
//        cell.setCellStyle(style);
//
//        cell = row1.createCell(1);
//        cell.setCellValue("facade");
//        cell.setCellStyle(style);
//
//        cell = row1.createCell(2);
//        cell.setCellValue("访问量");
//        cell.setCellStyle(style);
//        int createRow = 0;
//        for (Map.Entry<String, Map<String, String>> entry : result.entrySet()) {
//            String k = entry.getKey();
//            Map<String, String> v = entry.getValue();
//            row1 = sheet.createRow(3+createRow);
//            row1.createCell(0).setCellValue(k);
//            row1.createCell(1).setCellValue(v.get("facade"));
//            row1.createCell(2).setCellValue(Integer.parseInt(v.get("访问量")==null ? "0":v.get("访问量")));
//            createRow++;
//
//        }
//
//        try {
//            String path = "/Users/yp-tc-m-4820/Desktop/api.xlsx";
//            File file = new File(path);
//            //如果已经存在则删除
//            if (file.exists()) {
//                file.delete();
//            }
//            //创建文件
//            file.createNewFile();
//            FileOutputStream fout = new FileOutputStream(path);
//            wb.write(fout);
//            String str = "导出成功！";
//            System.out.println(str);
//            fout.close();
//        }catch (Exception e){
//            System.out.println(e);
//        }
//
//
//
    }
//
}
