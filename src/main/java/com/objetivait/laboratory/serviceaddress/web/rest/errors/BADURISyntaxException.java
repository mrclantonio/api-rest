package com.objetivait.laboratory.serviceaddress.web.rest.errors;

import java.net.URISyntaxException;

public class BADURISyntaxException extends URISyntaxException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public BADURISyntaxException (String input, String reason) {
        super(input, reason);
    }
    public BADURISyntaxException (String input, String reason, int index) {
        super(input, reason, index);
    }
    
}
