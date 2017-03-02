/**
 * 
 */
package io.mycat.plan.common.item.function.timefunc;

import java.util.List;

import io.mycat.config.ErrorCode;
import io.mycat.plan.common.exception.MySQLOutPutException;
import io.mycat.plan.common.item.Item;
import io.mycat.plan.common.item.function.ItemFunc;
import io.mycat.plan.common.time.MySQLTime;

/**
 * timezone change,not support
 * 
 */
public class ItemFuncConvTz extends ItemDatetimeFunc {

	public ItemFuncConvTz(List<Item> args) {
		super(args);
	}

	@Override
	public final String funcName() {
		return "convert_tz";
	}

	@Override
	public void fixLengthAndDec() {
		maybeNull = true;
	}

	@Override
	public boolean getDate(MySQLTime ltime, long fuzzy_date) {
		throw new MySQLOutPutException(ErrorCode.ER_OPTIMIZER, "", "unsupported function convert_tz!");
	}

	@Override
	public ItemFunc nativeConstruct(List<Item> realArgs) {
		return new ItemFuncConvTz(realArgs);
	}

}