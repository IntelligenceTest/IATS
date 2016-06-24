package com.autostreets.biz.auction.exception;

/**
 * GenericEntityException
 * @importer zhenxing.li
 */
@SuppressWarnings("serial")
public class GenericEntityException extends GeneralException {

    public GenericEntityException() {
        super();
    }

    public GenericEntityException(Throwable nested) {
        super(nested);
    }

    public GenericEntityException(String str) {
        super(str);
    }

    public GenericEntityException(String str, Throwable nested) {
        super(str, nested);
    }
}