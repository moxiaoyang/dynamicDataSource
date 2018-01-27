package datasource;

/**
 * @author 莫小阳
 */
public class DynamicDataSourceHolder {
    /**
     * 线程局部变量（多线程并发设计，为了线程安全）
     */
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal();

    /**
     * 设置数据源类型
     *
     * @param dataSourceType 数据源
     */
    public static void setDataSourceType(String dataSourceType) {
        CONTEXT_HOLDER.set(dataSourceType);
    }

    /**
     * 获取数据源类型
     *
     * @return 结果
     */
    public static String getDataSourceType() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 清除数据源类型
     */
    public static void clearDataSourceType() {
        CONTEXT_HOLDER.remove();
    }
}
