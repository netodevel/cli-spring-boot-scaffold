package br.com.attributes;

/**
 * 
 * @author NetoDevel
 *
 */
public class Project {

    private String srcMainJava;
    private String srcMainResources;
    private String srcTestJava;
    private String srcTestResources;
    private String target;

    public Project(){
    }

    public Project(String srcMainJava, String srcMainResources, String srcTestJava, String srcTestResources, String target) {
        this.srcMainJava = srcMainJava;
        this.srcMainResources = srcMainResources;
        this.srcTestJava = srcTestJava;
        this.srcTestResources = srcTestResources;
        this.target = target;
    }

    public String getSrcMainJava() {
        return srcMainJava;
    }

    public void setSrcMainJava(String srcMainJava) {
        this.srcMainJava = srcMainJava;
    }

    public String getSrcMainResources() {
        return srcMainResources;
    }

    public void setSrcMainResources(String srcMainResources) {
        this.srcMainResources = srcMainResources;
    }

    public String getSrcTestJava() {
        return srcTestJava;
    }

    public void setSrcTestJava(String srcTestJava) {
        this.srcTestJava = srcTestJava;
    }

    public String getSrcTestResources() {
        return srcTestResources;
    }

    public void setSrcTestResources(String srcTestResources) {
        this.srcTestResources = srcTestResources;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
