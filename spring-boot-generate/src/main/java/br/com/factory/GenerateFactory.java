package br.com.factory;

import br.com.strategy.ControllerGenerateStrategy;
import br.com.strategy.ModelGenerateStrategy;
import br.com.strategy.ProjectGenerateStrategy;
import br.com.strategy.RepositoryGenerateStrategy;
import br.com.strategy.ServiceGenerateStrategy;

/**
 * Defines which strategy to invoke for generate
 * @author NetoDevel
 */
public class GenerateFactory {

	public void getStrategy(String typeGenerate, String nameProject, String optionValue, String database) {
		switch (typeGenerate) {
		case "init":
			new ProjectGenerateStrategy(nameProject, database);
			break;
		case "model":
			new ModelGenerateStrategy(nameProject, optionValue);
			break;
		case "repository":
			new RepositoryGenerateStrategy(nameProject);
			break;
		case "service":
			new ServiceGenerateStrategy(nameProject);
			break;
		case "controller":
			new ControllerGenerateStrategy(nameProject);
			break;
		case "scaffold":
			scaffoldGenerate(nameProject, optionValue);
			break;
		default:
			break;
		}
	}

	private void scaffoldGenerate(String nameProject, String optionValue) {
		new ModelGenerateStrategy(nameProject, optionValue);
		new RepositoryGenerateStrategy(nameProject);
		new ServiceGenerateStrategy(nameProject);
		new ControllerGenerateStrategy(nameProject);
	}
}
