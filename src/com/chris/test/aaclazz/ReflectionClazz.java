package com.chris.test.aaclazz;


@AnnotationClazz("clazzForReflect")
public class ReflectionClazz {
    private int secretParam1;
    private String secretParam2;
    @ValidateParam(min = 10, max = 20, value = 15)
    private int validateParam;
    @ValidateParam(min = 50, max = 100, value = 60)
    public int validateParam2;
    public int param1;
    public String param2;

    public ReflectionClazz() {
        System.out.println("ReflectionClazz call");
    }

    public ReflectionClazz(int secretParam1, String secretParam2, int param1, String param2) {
        System.out.println("ReflectionClazz with param call");
        this.secretParam1 = secretParam1;
        this.secretParam2 = secretParam2;
        this.param1 = param1;
        this.param2 = param2;
    }

    public int getSecretParam1() {
        System.out.println("getSecretParam1 call");
        return secretParam1;
    }

    public String getSecretParam2() {
        System.out.println("getSecretParam2 call");
        return secretParam2;
    }

    public int getParam1() {
        System.out.println("getParam1 call");
        return param1;
    }

    public String getParam2() {
        System.out.println("getParam2 call");
        return param2;
    }

    private void secretMethod() {
        System.out.println("secretMethod call");
    }

    private String secretMethod(String p1, int p2) {
        System.out.println("secretMethod call p1=" + p1 + ", p2=" + p2);
        return String.format("p1=%s, p2=%d", p1, p2);
    }
}
