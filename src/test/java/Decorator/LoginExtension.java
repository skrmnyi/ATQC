package Decorator;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;


// observer
public class LoginExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        System.out.println("The test is started: " + context.getDisplayName());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        System.out.println("The test is finished: " + context.getDisplayName());

    }
}
