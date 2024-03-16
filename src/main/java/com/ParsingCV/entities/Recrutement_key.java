package com.ParsingCV.entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class Recrutement_key implements Serializable {

 
    /**
	 * 
	 */
	private static final long serialVersionUID = -4115445978699992503L;
	private Long idCondidat;  
    private Long idOffre; //  
 }

