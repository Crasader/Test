package test_case;

import java.util.List;

import org.cocos2dx.cpp.SIMCardInfo;

import android.content.Context;
import android.telephony.NeighboringCellInfo;
import android.util.Log;
import android.widget.Toast;

import com.cn.test.R;

/**
 * SIMCardInfo�Ĳ�������
 * 
 * @author yss
 *
 */
public class TestSIMCardInfo {

	private SIMCardInfo simCardInfo = null;

	public TestSIMCardInfo(Context context) {
		simCardInfo = new SIMCardInfo(context);

		String tmp = context.getString(R.string.operators_name);

		Toast.makeText(context, String.format(tmp, simCardInfo.getOperators()),
				Toast.LENGTH_LONG).show();
		Log.e("AppActivity", "��Ӫ�̣�" + simCardInfo.getOperators() + ",��Ӫ������:"
				+ simCardInfo.getOperatorsName());
		Log.e("AppActivity", "�绰����:" + simCardInfo.getPhoneNumber());
		//
		// ���ص�ǰ�ƶ��ն˸����ƶ��ն˵���Ϣ
		List<NeighboringCellInfo> infos = simCardInfo.getNeighboringCellInfo();
		if (infos != null) {
			if (infos.size() > 0) {
				for (NeighboringCellInfo info : infos) {
					// ��ȡ�ھ�С����
					int cid = info.getCid();
					// ��ȡ�ھ�С��LAC��LAC:
					// λ�������롣Ϊ��ȷ���ƶ�̨��λ�ã�ÿ��GSM/PLMN�ĸ������������ֳ����λ������LAC�����ڱ�ʶ��ͬ��λ������
					info.getLac();
					info.getNetworkType();
					info.getPsc();
					// ��ȡ�ھ�С���ź�ǿ��
					info.getRssi();
					Log.e("AppActivity", "lac:" + info.getLac());
				}
			}
		} else {
			Log.e("AppActivity", "null");
		}
	}
}
