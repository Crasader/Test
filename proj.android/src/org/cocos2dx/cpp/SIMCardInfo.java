package org.cocos2dx.cpp;

import java.util.List;

import android.content.Context;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import enums.Operators;

/**
 * 手机SIM卡信息
 * 
 * @author yss
 *
 */
public class SIMCardInfo {
	/**
	 * TelephonyManager提供了获取设备的通讯服务信息的入口。
	 * 其中包括手机SIM的状态和信息、电信网络的状态及手机用户的信息。应用程序可以使用这个类方法确定的电信服务商和国家 以及某些类型的用户访问信息。
	 * 应用程序也可以注册一个监听器到电话收状态的变化。不需要直接实例化这个类
	 * 使用Context.getSystemService(Context.TELEPHONY_SERVICE)来获取这个类的实例。
	 */
	private TelephonyManager telephonyManager;
	/**
	 * 国际移动用户识别码
	 */
	private String IMSI;

	public SIMCardInfo(Context context) {
		telephonyManager = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);

	}

	/**
	 * 返回当前移动终端附近的移动终端的信息;需要权限：android.permission.ACCESS_COARSE_LOCATION
	 * 
	 * @return
	 */
	public List<NeighboringCellInfo> getNeighboringCellInfo() {
		return telephonyManager.getNeighboringCellInfo();
		// // 返回当前移动终端附近移动终端的信息
		// List<NeighboringCellInfo> infos = telephonyManager
		// .getNeighboringCellInfo();
		// for (NeighboringCellInfo info : infos) {
		// // 获取邻居小区号
		// int cid = info.getCid();
		// // 获取邻居小区LAC，LAC:
		// // 位置区域码。为了确定移动台的位置，每个GSM/PLMN的覆盖区都被划分成许多位置区，LAC则用于标识不同的位置区。
		// info.getLac();
		// info.getNetworkType();
		// info.getPsc();
		// // 获取邻居小区信号强度
		// info.getRssi();
		// }
	}

	/**
	 * 返回手机是否有 ICC卡
	 * 
	 * @return
	 */
	public boolean hasIccCard() {
		return telephonyManager.hasIccCard();
	}

	/**
	 * 返回手机是否处于漫游状态【 在GSM用途下】
	 * 
	 * @return
	 */
	public boolean isNetworkRoaming() {
		// telephonyManager.listen(PhoneStateListener listener, int events) ;
		return telephonyManager.isNetworkRoaming();

	}

	/**
	 * 返回语音邮件号码
	 * 
	 * @return
	 */
	public String getVoiceMailNumber() {
		return telephonyManager.getVoiceMailNumber();
	}

	/**
	 * 获取语音信箱号码关联的字母标识。
	 * 
	 * @return
	 */
	public String getVoiceMailAlphaTag() {
		return telephonyManager.getVoiceMailAlphaTag();
	}

	/**
	 * 返回SIM卡的序列号(IMEI)
	 * 
	 * @return
	 */
	public String getSimSerialNumber() {
		return telephonyManager.getSimSerialNumber();
	}

	/**
	 * 获取 ISO国家码，相当于提供SIM卡的国家码
	 * 
	 * @return
	 */
	public String getSimCountryIso() {
		return telephonyManager.getSimCountryIso();
	}

	/**
	 * 返回MCC+MNC代码 (SIM卡运营商国家代码和运营商网络代码)(IMSI)【SIM卡的状态必须是
	 * SIM_STATE_READY(使用getSimState()判断)】
	 * 
	 * @return
	 */
	public String getSimOperator() {
		return telephonyManager.getSimOperator();
	}

	/**
	 * 获取 服务商名称【 SIM卡的状态必须是 SIM_STATE_READY(使用getSimState()判断)】
	 * 
	 * @return
	 */
	public String getSimOperatorName() {
		return telephonyManager.getSimOperatorName();
	}

	/**
	 * 返回MCC+MNC代码 (SIM卡运营商国家代码和运营商网络代码)(IMSI)【 注意：仅当用户已在网络注册时有效。
	 * 在CDMA网络中结果也许不可靠】
	 * 
	 * @return
	 */
	public String getNetworkOperator() {
		return telephonyManager.getNetworkOperator();
	}

	/**
	 * 返回移动网络运营商的名字(SPN)(注意：仅当用户已在网络注册时有效,在CDMA网络中结果也许不可靠)
	 * 
	 * @return
	 */
	public String getNetworkOperatorName() {
		return telephonyManager.getNetworkOperatorName();

	}

	/**
	 * 返回ISO标准的国家码，即国际长途区号【注意：仅当用户已在网络注册后有效。 在CDMA网络中结果也许不可靠】
	 * 
	 * @return
	 */
	public String getNetworkCountryIso() {
		return telephonyManager.getNetworkCountryIso();
	}

	/**
	 * 获取网络类型
	 * 
	 * NETWORK_TYPE_CDMA:网络类型为CDMA; NETWORK_TYPE_EDGE 网络类型为EDGE;
	 * NETWORK_TYPE_EVDO_0:网络类型为EVDO0; NETWORK_TYPE_EVDO_A 网络类型为EVDOA;
	 * NETWORK_TYPE_GPRS:网络类型为GPRS; NETWORK_TYPE_HSDPA 网络类型为HSDPA;
	 * NETWORK_TYPE_HSPA:网络类型为HSPA; NETWORK_TYPE_HSUPA 网络类型为HSUPA;
	 * NETWORK_TYPE_UMTS:网络类型为UMTS;
	 * 
	 * 在中国，联通的3G为UMTS或HSDPA，移动和联通的2G为GPRS或EGDE，电信的2G为CDMA，电信的3G为EVDO
	 * 
	 * @return
	 */
	public int getNetworkType() {
		return telephonyManager.getNetworkType();
	}

	/**
	 * 获取 手机制式
	 * 
	 * PHONE_TYPE_CDMA:手机制式为CDMA，电信; PHONE_TYPE_GSM:手机制式为GSM，移动和联通;
	 * PHONE_TYPE_NONE:手机制式未知;
	 * 
	 * @return
	 */
	public int getPhoneType() {
		return telephonyManager.getPhoneType();
	}

	/**
	 * 返回移动终端
	 * 
	 * SIM_STATE_ABSENT:SIM卡未找到; SIM_STATE_NETWORK_LOCKED:SIM卡网络被锁定，需要Network
	 * PIN解锁; SIM_STATE_PIN_REQUIRED:SIM卡PIN被锁定，需要User PIN解锁;
	 * SIM_STATE_PUK_REQUIRED:SIM卡PUK被锁定，需要User PUK解锁 SIM_STATE_READY SIM卡可用;
	 * SIM_STATE_UNKNOWN:SIM卡未知;
	 * 
	 * @return
	 */
	public int getSimState() {
		return telephonyManager.getSimState();
	}

	/**
	 * 返回移动终端的软件版本号，例如：GSM手机的IMEI/SV码
	 * 
	 * @return
	 */
	public String getDeviceSoftwareVersion() {
		return telephonyManager.getDeviceSoftwareVersion();
	}

	/**
	 * 返回当前移动终端的唯一标识；如果是GSM网络，返回IMEI；如果是CDMA网络，返回MEID/ESN
	 * 
	 * @return
	 */
	public String getDeviceId() {
		return telephonyManager.getDeviceId();
	}

	/**
	 * 返回当前移动终端的位置
	 * 
	 * @return
	 */
	public CellLocation getCellLocation() {
		return telephonyManager.getCellLocation();
		// 请求位置更新，如果更新将产生广播，接收对象为注册LISTEN_CELL_LOCATION的对象，需要的permission名称为ACCESS_COARSE_LOCATION。
		// location.requestLocationUpdate();
	}

	/**
	 * 获取数据连接状态
	 * 
	 * DATA_CONNECTED:数据连接状态：已连接; DATA_CONNECTING:数据连接状态：正在连接;
	 * DATA_DISCONNECTED:数据连接状态：断开; DATA_SUSPENDED:数据连接状态：暂停;
	 */
	public int getDataState() {
		return telephonyManager.getDataState();
	}

	/**
	 * 获取数据活动状态
	 * 
	 * DATA_ACTIVITY_IN:数据连接状态：活动，正在接受数据; DATA_ACTIVITY_OUT 数据连接状态：活动，正在发送数据;
	 * DATA_ACTIVITY_INOUT:数据连接状态：活动，正在接受和发送数据;
	 * DATA_ACTIVITY_NONE:数据连接状态：活动，但无数据发送和接受;
	 */
	public int getDataActivity() {
		return telephonyManager.getDataActivity();
	}

	/**
	 * 返回电话状态
	 * 
	 * CALL_STATE_IDLE:无任何状态时; CALL_STATE_OFFHOOK:接起电话时;
	 * CALL_STATE_RINGING:电话进来时
	 */
	public int getCallState() {
		return telephonyManager.getCallState();
	}

	/**
	 * 获取当前设置的电话号码，对于GSM网络来说即MSISDN(有些手机号无法获取，是因为运营商在SIM中没有写入手机号)
	 */
	public String getPhoneNumber() {
		return telephonyManager.getLine1Number();
	}

	public String getOperatorsName() {
		return telephonyManager.getSimOperatorName();
	}

	/**
	 * 获取唯一的客户id，如果是GSM网络,就是IMSI
	 * 
	 * @return
	 */
	public String getSubscriberId() {
		return telephonyManager.getSubscriberId();
	}

	/**
	 * 返回运营商
	 * 
	 * @param context
	 * @return
	 * @use 需要加入权限 <uses-permission
	 *      android:name="android.permission.READ_PHONE_STATE"/>
	 * @shuoming 移动设备网络代码（Mobile Network Code，MNC）是与移动设备国家代码（Mobile Country
	 *           Code，MCC）（也称为“MCC/MNC”）相结合, 例如46000，前三位是MCC表示国家，后两位是MNC，表示运营商代码
	 *           (00/02/07是中国移动，01是中国联通，03是中国电信)
	 *           BTW:因为移动网络编号46000下的IMSI已经用完，所以虚拟了一个46002编号，134/159号段使用了此编号
	 */
	public String getOperators() {
		String operatorsName = Operators.NONE;
		// 返回用户唯一标识，比如GSM网络的IMSI编号
		String IMSI = getSubscriberId();
		// telephonyManager.getSimOperator()
		if (IMSI != null) {
			if (IMSI.startsWith("46000") || IMSI.startsWith("46002")
					|| IMSI.startsWith("46007")) {
				operatorsName = Operators.CMCC;
			} else if (IMSI.startsWith("46001") || IMSI.startsWith("46006")) {
				operatorsName = Operators.CHU;
			} else if (IMSI.startsWith("46003") || IMSI.startsWith("46005")) {
				operatorsName = Operators.CHA;
			}
			System.out.println(IMSI);
			// 如果手机没有插入SIM卡，此时得到的IMSI是null，执行输出的话会报错："hal_timestamp_calc:
			// Adjusting
			// timestamp for rollover:
			// 1440062544308577889, -1".这个游戏直接闪退。
		}
		return operatorsName;
	}
	// 解释：
	// IMSI是国际移动用户识别码的简称(International Mobile Subscriber Identity)
	// IMSI共有15位，其结构如下：
	// MCC+MNC+MIN
	// MCC：Mobile Country Code，移动国家码，共3位，中国为460;
	// MNC:Mobile NetworkCode，移动网络码，共2位
	// 在中国，移动的代码为电00和02，联通的代码为01，电信的代码为03
	// 合起来就是（也是Android手机中APN配置文件中的代码）：
	// 中国移动：46000 46002 46007
	// 中国联通：46001
	// 中国电信：46003
	// 举例，一个典型的IMSI号码为460030912121001

	// IMEI是International Mobile Equipment Identity （国际移动设备标识）的简称
	// IMEI由15位数字组成的”电子串号”，它与每台手机一一对应，而且该码是全世界唯一的
	// 其组成为：
	// 1. 前6位数(TAC)是”型号核准号码”，一般代表机型
	// 2. 接着的2位数(FAC)是”最后装配号”，一般代表产地
	// 3. 之后的6位数(SNR)是”串号”，一般代表生产顺序号
	// 4. 最后1位数(SP)通常是”0″，为检验码，目前暂备用
}
