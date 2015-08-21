package test_case;

import java.util.List;

import org.cocos2dx.cpp.SIMCardInfo;

import android.content.Context;
import android.telephony.NeighboringCellInfo;
import android.util.Log;
import android.widget.Toast;

import com.cn.test.R;

/**
 * SIMCardInfo的测试用例
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
		Log.e("AppActivity", "运营商：" + simCardInfo.getOperators() + ",运营的名字:"
				+ simCardInfo.getOperatorsName());
		Log.e("AppActivity", "电话号码:" + simCardInfo.getPhoneNumber());
		//
		// 返回当前移动终端附近移动终端的信息
		List<NeighboringCellInfo> infos = simCardInfo.getNeighboringCellInfo();
		if (infos != null) {
			if (infos.size() > 0) {
				for (NeighboringCellInfo info : infos) {
					// 获取邻居小区号
					int cid = info.getCid();
					// 获取邻居小区LAC，LAC:
					// 位置区域码。为了确定移动台的位置，每个GSM/PLMN的覆盖区都被划分成许多位置区，LAC则用于标识不同的位置区。
					info.getLac();
					info.getNetworkType();
					info.getPsc();
					// 获取邻居小区信号强度
					info.getRssi();
					Log.e("AppActivity", "lac:" + info.getLac());
				}
			}
		} else {
			Log.e("AppActivity", "null");
		}
	}
}
