package br.com.jsn.noleggio.main.validation;

import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.primefaces.context.RequestContext;

import br.com.jsn.noleggio.main.qualifier.SavePreValidate;
import br.com.jsn.noleggio.modules.cliente.model.Cliente;

@RequestScoped
public class ValidationModelBusiness {
	
	@Inject
	private Validator validator;
	
	public void validateModel(@Observes @SavePreValidate Cliente cliente) {
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cliente);
		constraintViolations.size();
		
		for (ConstraintViolation<Cliente> constraintViolation : constraintViolations) {
			addMessageError(constraintViolation.getMessage());
			constraintViolation.getInvalidValue();
		}
		
	}
	
	private static void addMessage(Severity severity, String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, "", message));
	}
	
	public static void addMessageInfo(String message) {
		addMessage(FacesMessage.SEVERITY_INFO, message);
	}

	public static void addMessageWarn(String message) {
		addMessage(FacesMessage.SEVERITY_WARN, message);
	}

	public static void addMessageError(String message) {
		addBusinessErroCallbackParam();
		addMessage(FacesMessage.SEVERITY_ERROR, message);
	}
	
	private static void addBusinessErroCallbackParam() {
		RequestContext rc = RequestContext.getCurrentInstance();
		if (rc != null) {
			// Parâmetro businessError usado pelo componente framework:messageHide 
			// também pode ser usado para manter um dialog de erro aberto
			rc.addCallbackParam("businessError", true);
		}
	}
}
