package org.cocos2dx.cpp;

import java.util.List;

import android.content.Context;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import enums.Operators;

/**
 * �ֻ�SIM����Ϣ
 * 
 * @author yss
 *
 */
public class SIMCardInfo {
	/**
	 * TelephonyManager�ṩ�˻�ȡ�豸��ͨѶ������Ϣ����ڡ�
	 * ���а����ֻ�SIM��״̬����Ϣ�����������״̬���ֻ��û�����Ϣ��Ӧ�ó������ʹ������෽��ȷ���ĵ��ŷ����̺͹��� �Լ�ĳЩ���͵��û�������Ϣ��
	 * Ӧ�ó���Ҳ����ע��һ�����������绰��״̬�ı仯������Ҫֱ��ʵ���������
	 * ʹ��Context.getSystemService(Context.TELEPHONY_SERVICE)����ȡ������ʵ����
	 */
	private TelephonyManager telephonyManager;
	/**
	 * �����ƶ��û�ʶ����
	 */
	private String IMSI;

	public SIMCardInfo(Context context) {
		telephonyManager = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);

	}

	/**
	 * ���ص�ǰ�ƶ��ն˸������ƶ��ն˵���Ϣ;��ҪȨ�ޣ�android.permission.ACCESS_COARSE_LOCATION
	 * 
	 * @return
	 */
	public List<NeighboringCellInfo> getNeighboringCellInfo() {
		return telephonyManager.getNeighboringCellInfo();
		// // ���ص�ǰ�ƶ��ն˸����ƶ��ն˵���Ϣ
		// List<NeighboringCellInfo> infos = telephonyManager
		// .getNeighboringCellInfo();
		// for (NeighboringCellInfo info : infos) {
		// // ��ȡ�ھ�С����
		// int cid = info.getCid();
		// // ��ȡ�ھ�С��LAC��LAC:
		// // λ�������롣Ϊ��ȷ���ƶ�̨��λ�ã�ÿ��GSM/PLMN�ĸ������������ֳ����λ������LAC�����ڱ�ʶ��ͬ��λ������
		// info.getLac();
		// info.getNetworkType();
		// info.getPsc();
		// // ��ȡ�ھ�С���ź�ǿ��
		// info.getRssi();
		// }
	}

	/**
	 * �����ֻ��Ƿ��� ICC��
	 * 
	 * @return
	 */
	public boolean hasIccCard() {
		return telephonyManager.hasIccCard();
	}

	/**
	 * �����ֻ��Ƿ�������״̬�� ��GSM��;�¡�
	 * 
	 * @return
	 */
	public boolean isNetworkRoaming() {
		// telephonyManager.listen(PhoneStateListener listener, int events) ;
		return telephonyManager.isNetworkRoaming();

	}

	/**
	 * ���������ʼ�����
	 * 
	 * @return
	 */
	public String getVoiceMailNumber() {
		return telephonyManager.getVoiceMailNumber();
	}

	/**
	 * ��ȡ������������������ĸ��ʶ��
	 * 
	 * @return
	 */
	public String getVoiceMailAlphaTag() {
		return telephonyManager.getVoiceMailAlphaTag();
	}

	/**
	 * ����SIM�������к�(IMEI)
	 * 
	 * @return
	 */
	public String getSimSerialNumber() {
		return telephonyManager.getSimSerialNumber();
	}

	/**
	 * ��ȡ ISO�����룬�൱���ṩSIM���Ĺ�����
	 * 
	 * @return
	 */
	public String getSimCountryIso() {
		return telephonyManager.getSimCountryIso();
	}

	/**
	 * ����MCC+MNC���� (SIM����Ӫ�̹��Ҵ������Ӫ���������)(IMSI)��SIM����״̬������
	 * SIM_STATE_READY(ʹ��getSimState()�ж�)��
	 * 
	 * @return
	 */
	public String getSimOperator() {
		return telephonyManager.getSimOperator();
	}

	/**
	 * ��ȡ ���������ơ� SIM����״̬������ SIM_STATE_READY(ʹ��getSimState()�ж�)��
	 * 
	 * @return
	 */
	public String getSimOperatorName() {
		return telephonyManager.getSimOperatorName();
	}

	/**
	 * ����MCC+MNC���� (SIM����Ӫ�̹��Ҵ������Ӫ���������)(IMSI)�� ע�⣺�����û���������ע��ʱ��Ч��
	 * ��CDMA�����н��Ҳ���ɿ���
	 * 
	 * @return
	 */
	public String getNetworkOperator() {
		return telephonyManager.getNetworkOperator();
	}

	/**
	 * �����ƶ�������Ӫ�̵�����(SPN)(ע�⣺�����û���������ע��ʱ��Ч,��CDMA�����н��Ҳ���ɿ�)
	 * 
	 * @return
	 */
	public String getNetworkOperatorName() {
		return telephonyManager.getNetworkOperatorName();

	}

	/**
	 * ����ISO��׼�Ĺ����룬�����ʳ�;���š�ע�⣺�����û���������ע�����Ч�� ��CDMA�����н��Ҳ���ɿ���
	 * 
	 * @return
	 */
	public String getNetworkCountryIso() {
		return telephonyManager.getNetworkCountryIso();
	}

	/**
	 * ��ȡ��������
	 * 
	 * NETWORK_TYPE_CDMA:��������ΪCDMA; NETWORK_TYPE_EDGE ��������ΪEDGE;
	 * NETWORK_TYPE_EVDO_0:��������ΪEVDO0; NETWORK_TYPE_EVDO_A ��������ΪEVDOA;
	 * NETWORK_TYPE_GPRS:��������ΪGPRS; NETWORK_TYPE_HSDPA ��������ΪHSDPA;
	 * NETWORK_TYPE_HSPA:��������ΪHSPA; NETWORK_TYPE_HSUPA ��������ΪHSUPA;
	 * NETWORK_TYPE_UMTS:��������ΪUMTS;
	 * 
	 * ���й�����ͨ��3GΪUMTS��HSDPA���ƶ�����ͨ��2GΪGPRS��EGDE�����ŵ�2GΪCDMA�����ŵ�3GΪEVDO
	 * 
	 * @return
	 */
	public int getNetworkType() {
		return telephonyManager.getNetworkType();
	}

	/**
	 * ��ȡ �ֻ���ʽ
	 * 
	 * PHONE_TYPE_CDMA:�ֻ���ʽΪCDMA������; PHONE_TYPE_GSM:�ֻ���ʽΪGSM���ƶ�����ͨ;
	 * PHONE_TYPE_NONE:�ֻ���ʽδ֪;
	 * 
	 * @return
	 */
	public int getPhoneType() {
		return telephonyManager.getPhoneType();
	}

	/**
	 * �����ƶ��ն�
	 * 
	 * SIM_STATE_ABSENT:SIM��δ�ҵ�; SIM_STATE_NETWORK_LOCKED:SIM�����类��������ҪNetwork
	 * PIN����; SIM_STATE_PIN_REQUIRED:SIM��PIN����������ҪUser PIN����;
	 * SIM_STATE_PUK_REQUIRED:SIM��PUK����������ҪUser PUK���� SIM_STATE_READY SIM������;
	 * SIM_STATE_UNKNOWN:SIM��δ֪;
	 * 
	 * @return
	 */
	public int getSimState() {
		return telephonyManager.getSimState();
	}

	/**
	 * �����ƶ��ն˵�����汾�ţ����磺GSM�ֻ���IMEI/SV��
	 * 
	 * @return
	 */
	public String getDeviceSoftwareVersion() {
		return telephonyManager.getDeviceSoftwareVersion();
	}

	/**
	 * ���ص�ǰ�ƶ��ն˵�Ψһ��ʶ�������GSM���磬����IMEI�������CDMA���磬����MEID/ESN
	 * 
	 * @return
	 */
	public String getDeviceId() {
		return telephonyManager.getDeviceId();
	}

	/**
	 * ���ص�ǰ�ƶ��ն˵�λ��
	 * 
	 * @return
	 */
	public CellLocation getCellLocation() {
		return telephonyManager.getCellLocation();
		// ����λ�ø��£�������½������㲥�����ն���Ϊע��LISTEN_CELL_LOCATION�Ķ�����Ҫ��permission����ΪACCESS_COARSE_LOCATION��
		// location.requestLocationUpdate();
	}

	/**
	 * ��ȡ��������״̬
	 * 
	 * DATA_CONNECTED:��������״̬��������; DATA_CONNECTING:��������״̬����������;
	 * DATA_DISCONNECTED:��������״̬���Ͽ�; DATA_SUSPENDED:��������״̬����ͣ;
	 */
	public int getDataState() {
		return telephonyManager.getDataState();
	}

	/**
	 * ��ȡ���ݻ״̬
	 * 
	 * DATA_ACTIVITY_IN:��������״̬��������ڽ�������; DATA_ACTIVITY_OUT ��������״̬��������ڷ�������;
	 * DATA_ACTIVITY_INOUT:��������״̬��������ڽ��ܺͷ�������;
	 * DATA_ACTIVITY_NONE:��������״̬������������ݷ��ͺͽ���;
	 */
	public int getDataActivity() {
		return telephonyManager.getDataActivity();
	}

	/**
	 * ���ص绰״̬
	 * 
	 * CALL_STATE_IDLE:���κ�״̬ʱ; CALL_STATE_OFFHOOK:����绰ʱ;
	 * CALL_STATE_RINGING:�绰����ʱ
	 */
	public int getCallState() {
		return telephonyManager.getCallState();
	}

	/**
	 * ��ȡ��ǰ���õĵ绰���룬����GSM������˵��MSISDN(��Щ�ֻ����޷���ȡ������Ϊ��Ӫ����SIM��û��д���ֻ���)
	 */
	public String getPhoneNumber() {
		return telephonyManager.getLine1Number();
	}

	public String getOperatorsName() {
		return telephonyManager.getSimOperatorName();
	}

	/**
	 * ��ȡΨһ�Ŀͻ�id�������GSM����,����IMSI
	 * 
	 * @return
	 */
	public String getSubscriberId() {
		return telephonyManager.getSubscriberId();
	}

	/**
	 * ������Ӫ��
	 * 
	 * @param context
	 * @return
	 * @use ��Ҫ����Ȩ�� <uses-permission
	 *      android:name="android.permission.READ_PHONE_STATE"/>
	 * @shuoming �ƶ��豸������루Mobile Network Code��MNC�������ƶ��豸���Ҵ��루Mobile Country
	 *           Code��MCC����Ҳ��Ϊ��MCC/MNC��������, ����46000��ǰ��λ��MCC��ʾ���ң�����λ��MNC����ʾ��Ӫ�̴���
	 *           (00/02/07���й��ƶ���01���й���ͨ��03���й�����)
	 *           BTW:��Ϊ�ƶ�������46000�µ�IMSI�Ѿ����꣬����������һ��46002��ţ�134/159�Ŷ�ʹ���˴˱��
	 */
	public String getOperators() {
		String operatorsName = Operators.NONE;
		// �����û�Ψһ��ʶ������GSM�����IMSI���
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
			// ����ֻ�û�в���SIM������ʱ�õ���IMSI��null��ִ������Ļ��ᱨ��"hal_timestamp_calc:
			// Adjusting
			// timestamp for rollover:
			// 1440062544308577889, -1".�����Ϸֱ�����ˡ�
		}
		return operatorsName;
	}
	// ���ͣ�
	// IMSI�ǹ����ƶ��û�ʶ����ļ��(International Mobile Subscriber Identity)
	// IMSI����15λ����ṹ���£�
	// MCC+MNC+MIN
	// MCC��Mobile Country Code���ƶ������룬��3λ���й�Ϊ460;
	// MNC:Mobile NetworkCode���ƶ������룬��2λ
	// ���й����ƶ��Ĵ���Ϊ��00��02����ͨ�Ĵ���Ϊ01�����ŵĴ���Ϊ03
	// ���������ǣ�Ҳ��Android�ֻ���APN�����ļ��еĴ��룩��
	// �й��ƶ���46000 46002 46007
	// �й���ͨ��46001
	// �й����ţ�46003
	// ������һ�����͵�IMSI����Ϊ460030912121001

	// IMEI��International Mobile Equipment Identity �������ƶ��豸��ʶ���ļ��
	// IMEI��15λ������ɵġ����Ӵ��š�������ÿ̨�ֻ�һһ��Ӧ�����Ҹ�����ȫ����Ψһ��
	// �����Ϊ��
	// 1. ǰ6λ��(TAC)�ǡ��ͺź�׼���롱��һ��������
	// 2. ���ŵ�2λ��(FAC)�ǡ����װ��š���һ��������
	// 3. ֮���6λ��(SNR)�ǡ����š���һ���������˳���
	// 4. ���1λ��(SP)ͨ���ǡ�0�壬Ϊ�����룬Ŀǰ�ݱ���
}
