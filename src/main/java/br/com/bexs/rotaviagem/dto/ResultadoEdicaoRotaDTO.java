package br.com.bexs.rotaviagem.dto;

import java.util.ArrayList;
import java.util.List;

public class ResultadoEdicaoRotaDTO {
	private boolean success;
	private List<String> errors;

	public ResultadoEdicaoRotaDTO() {
		errors = new ArrayList<>();
	}

	public void addError(String error) {
		errors.add(error);
	}

	public void markAsSuccessful() {
		success = true;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
