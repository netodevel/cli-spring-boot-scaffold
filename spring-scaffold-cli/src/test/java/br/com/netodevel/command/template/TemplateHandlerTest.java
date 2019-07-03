package br.com.netodevel.command.template;

import org.junit.Test;
import org.springframework.boot.cli.command.status.ExitStatus;

public class TemplateHandlerTest {

    @Test
    public void shouldReturnStatusOk() throws Exception {
        TemplateHandler templateHandler = new TemplateHandler();
        ExitStatus exitStatus = templateHandler.run("-t", "api-rest");
    }

}