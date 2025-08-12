
public class WebAutomation {
    /* Use the below declared variable, do not modify anything */
    public static WebDriver driver;
    public static String baseUrl = "https://webapps.tekstac.com/RentaCar/";

    /*Do not change*/
    public WebAutomation() { }

    /*Do not change*/
    public WebAutomation(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeClass
    public void setupDriver() /*Do not change method signature*/ {
        // Set the path for the browser driver executable (e.g., geckodriver or chromedriver)
        // Initialize the WebDriver instance using the selected browser driver
        // Navigate to the application URL (baseUrl)
        System.setProperty("webdriver.gecko.driver", "/selenium/geckodriver");
        FirefoxOptions o = new FirefoxOptions();
        o.setHeadless(true);

        driver = new FirefoxDriver(o);
        driver.get(baseUrl);
    }

    @Test
    public String verifyResult() /*Do not change method signature*/ {
        // Enter 'Name' in the respective input field using sendKeys method
        // Enter 'Phone' number in the respective input field using sendKeys method
        // Enter 'Address' in the respective input field using sendKeys method
        // Enter 'Date' in the respective input field using sendKeys method
        // Select 'Car Type' from the dropdown using the selectByVisibleText method
        // Enter 'Duration' in the respective input field using sendKeys method
        // Click the 'Net Banking' button
        // Click the 'Submit' button
        // Retrieve and return the confirmation message

        driver.findElement(By.id("name")).sendKeys("chaitanya");
        driver.findElement(By.id("number")).sendKeys("9587896547");
        driver.findElement(By.id("address")).sendKeys("fsdfsffsd");
        driver.findElement(By.id("traveldate")).sendKeys("2024-02-02");
        Select s = new Select(driver.findElement(By.id("cartype")));
        s.selectByVisibleText("SUV");
        driver.findElement(By.id("duration")).sendKeys("2");
        driver.findElement(By.id("license")).sendKeys("2");
        driver.findElement(By.id("netbanking")).click();
        driver.findElement(By.id("submit")).click();

        String res = driver.findElement(By.id("result")).getText();
        return res;
    }

    @Test
    public String verify_PageTitle() /*Do not change method signature*/ {
        // Retrieve the current page title and return it
        String pt = driver.getTitle();
        return pt;
    }

    // Do not change anything in the main method
    public static void main(String[] args) {
        WebAutomation test = new WebAutomation();
        test.setupDriver();
        System.out.println("Form Result: " + test.verifyResult());
        System.out.println("Page Title: " + test.verify_PageTitle());
    }
}

===============================================================================
pipeline {
    agent any

 

    environment {
        HEADLESS_MODE = 'true' // Define headless mode in Jenkins pipeline
        DISPLAY = ':99' // Set display variable for headless execution
    }

 

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', credentialsId: 'gitlab-credentials', url: 'http://localhost/user1/myseleniumtest.git'
            }
        }

 

        stage('Setup Headless Environment') {
            steps {
                script {
                    echo "Starting virtual display (Xvfb)..."
                    sh 'Xvfb :99 -screen 0 1920x1080x24 &'
                    sh 'export DISPLAY=:99'
                }
            }
        }

 

        stage('Compile Java') {
            steps {
                script {
                    echo 'Compiling Java code with Selenium dependencies...'
                    sh 'javac -cp .:/selenium/Selenium4.11/* -d . src/WebAutomation.java'
                }
            }
        }

 

        stage('Run Application') {
            steps {
                script {
                    echo "Running Selenium with headless mode: ${env.HEADLESS_MODE}..."
                    sh "export DISPLAY=:99 && java -cp .:/selenium/Selenium4.11/* WebAutomation"
                }
            }
        }
    }

 

    post {
        always {
            echo 'Pipeline execution complete.'
        }
    }
}

