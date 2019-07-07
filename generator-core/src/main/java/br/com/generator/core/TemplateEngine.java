package br.com.generator.core;

import br.com.generator.core.exceptions.TemplateEngineException;

import java.util.Iterator;
import java.util.Map;

public class TemplateEngine implements EngineContract {

    public String replaceValues(String contentTemplate, Map<String, String> keyValues) {
        if (contentTemplate == null) throw new TemplateEngineException("contentTemplate can not be null");
        Iterator it = keyValues.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, String> pair = (Map.Entry) it.next();
            if (contentTemplate.contains(pair.getKey()))
                contentTemplate = contentTemplate.replace(pair.getKey(), pair.getValue());
//            it.remove();
        }

        return contentTemplate;
    }

}
