import javax.script.*;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Bernd on 29.08.2015.
 */
public class App {
    static final ScriptEngineManager manager = new ScriptEngineManager();

    static void println(String str ){
        System.out.println(str);
    }

    public static void main(String [] args) throws ScriptException, NoSuchMethodException, FileNotFoundException {

        final ScriptEngine engine = manager.getEngineByName("ECMAScript");
        Invocable invocable = (Invocable) engine;

        engine.eval(new FileReader("resources/base.js"));
        engine.eval(new FileReader("resources/script.js"));

        Person p = new Person("bernd");
        invocable.invokeFunction("printPersonName", p);

        // printInfo();
    }

    private static void printInfo() {
        for (final ScriptEngineFactory scriptEngine : manager.getEngineFactories()) {
            System.out.println(
                    scriptEngine.getEngineName() + " ("
                            + scriptEngine.getEngineVersion() + ")");
            System.out.println(
                    "\tLanguage: " + scriptEngine.getLanguageName() + "("
                            + scriptEngine.getLanguageVersion() + ")");
            System.out.println("\tCommon Names/Aliases: ");
            for (final String engineAlias : scriptEngine.getNames()) {
                System.out.println(engineAlias + " ");
            }
        }
    }
}
