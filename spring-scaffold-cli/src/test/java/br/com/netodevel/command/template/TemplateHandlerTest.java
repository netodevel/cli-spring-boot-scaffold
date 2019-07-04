package br.com.netodevel.command.template;

import org.junit.Test;
import org.springframework.boot.cli.command.status.ExitStatus;

import static org.junit.Assert.assertEquals;

public class TemplateHandlerTest {

    @Test
    public void shouldReturnOk() throws Exception {
        TemplateHandler templateHandler = new TemplateHandler();
        ExitStatus exitStatus = templateHandler.run("-t", "jms-aws-sqs");
        assertEquals(ExitStatus.OK, exitStatus);
    }

    @Test
    public void shouldReturnError() throws Exception {
        TemplateHandler templateHandler = new TemplateHandler();
        ExitStatus exitStatus = templateHandler.run("-t", "api-rest");
        assertEquals(ExitStatus.ERROR, exitStatus);
    }

    @Test
    public void givenArgumentList_shoudListTemplates() throws Exception {
        TemplateHandler templateHandler = new TemplateHandler();
        templateHandler.run("--list");
    }
}