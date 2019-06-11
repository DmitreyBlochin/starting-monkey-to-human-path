package AIT4.Blochin.wdad.data.managers;

public class Properties {

    private String createRegistry;
    private String registryAddress;
    private String registryPort;
    private String policyPath;
    private String useCodeBaseOnly;
    private String classProvider;

    public Properties(String value1, String value2, String value3, String value4, String value5, String value6){
        createRegistry = value1;
        registryAddress = value2;
        registryPort = value3;
        policyPath = value4;
        useCodeBaseOnly = value5;
        classProvider = value6;
    }

    public String getCreateRegistry() {
        return createRegistry;
    }

    public String getRegistryAddress() {
        return registryAddress;
    }

    public String getRegistryPort() {
        return registryPort;
    }

    public String getPolicyPath() {
        return policyPath;
    }

    public String getUseCodeBaseOnly() {
        return useCodeBaseOnly;
    }

    public String getClassProvider() {
        return classProvider;
    }

    public void setCreateRegistry(String createRegistry) {
        this.createRegistry = createRegistry;
    }

    public void setRegistryAddress(String registryAddress) {
        this.registryAddress = registryAddress;
    }

    public void setRegistryPort(String registryPort) {
        this.registryPort = registryPort;
    }

    public void setPolicyPath(String policyPath) {
        this.policyPath = policyPath;
    }

    public void setUseCodeBaseOnly(String useCodeBaseOnly) {
        this.useCodeBaseOnly = useCodeBaseOnly;
    }

    public void setClassProvider(String classProvider) { this.classProvider = classProvider; }

}

