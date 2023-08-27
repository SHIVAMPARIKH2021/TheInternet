package testData;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.net.URL;

public class GetRequestTestData {
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public Object getSupport() {
        return support;
    }

    public void setSupport(Object support) {
        this.support = support;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public Object data;
    public Object support;
}
