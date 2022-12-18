package pageUIs;

public class AdminOrderPageUI {
    public static final String STATUS_ITEM_AT_STATUS_DROPDOWN_BY_NAME = "css=select#sales_order_grid_filter_status";
    public static final String FIRST_ORDER_CHECKBOX = "xpath=//table[@id='sales_order_grid_table']//td[@class='a-center '][1]//input";
    public static final String ACTIONS_AT_ORDER_PAGE_DROPDOWN = "css=select#sales_order_grid_massaction-select";
    public static final String ORDER_VIEW_DROPDOWN = "css=select[name='limit']";
    public static final String ORDER_TABLE = "css=table#sales_order_grid_table>tbody tr";
    public static final String ORDER_SELECT_UNSELECT_LINK_BY_TEXT = "xpath=//a[text()='%s']";
    public static final String NUMBER_ITEMS_SELECTED_TEXT = "xpath=//strong[text()='%s']";
    public static final String TABLE_SELECTED_CHECKBOX = "css=input:checked[type='checkbox']";
    public static final String TABLE_UNSELECTED_CHECKBOX = "css=input:not(:checked)[type='checkbox']";
}
