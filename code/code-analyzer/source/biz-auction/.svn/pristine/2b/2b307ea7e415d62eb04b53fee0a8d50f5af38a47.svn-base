package com.autostreets.biz.auction.pagination;

import java.util.List;
import java.util.Map;

public final class Pagination1Utils {
    public static <T> Pagination1<T> newPagination(int pageSize, int pageNumber, int totalNumberOfElements, List<T> elements) {
        return new DefaultPagination1<T>(pageSize, pageNumber, totalNumberOfElements, elements);
    }

    public static <T> Pagination1<T> newPagination(int pageSize, int pageNumber, int totalNumberOfElements, List<T> elements, Map<String, Object> model) {
        return new DefaultPagination1<T>(pageSize, pageNumber, totalNumberOfElements, elements, model);
    }

    private Pagination1Utils() {
    }
}
