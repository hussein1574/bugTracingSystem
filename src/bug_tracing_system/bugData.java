
package bug_tracing_system;

/**
 *
 * @author husse
 */
public class bugData 
{            

    private final String ProjectName;
    private final int TesterId;
    private final int BugId;
    private final String BugName;
    private final String BugType;
    private final String Priorty;
    private final String Statue;
    private final String BugDetails;
    private final int DeveloperId;
    private final String ImageFileName;

    public bugData(String ProjectName, int TesterId, int BugId, String BugName, String BugType, String Priorty, String Statue, String BugDetails, int DeveloperId, String ImageFileName) {
        this.ProjectName = ProjectName;
        this.TesterId = TesterId;
        this.BugId = BugId;
        this.BugName = BugName;
        this.BugType = BugType;
        this.Priorty = Priorty;
        this.Statue = Statue;
        this.BugDetails = BugDetails;
        this.DeveloperId = DeveloperId;
        this.ImageFileName = ImageFileName;
    }
    public String getBugDetails() {
        return BugDetails;
    }

    public int getTesterId() {
        return TesterId;
    }

    public int getBugId() {
        return BugId;
    }


    public int getDeveloperId() {
        return DeveloperId;
    }

    public String getImageFileName() {
        return ImageFileName;
    }


    public String getProjectName() {
        return ProjectName;
    }

    public String getBugName() {
        return BugName;
    }

    public String getBugType() {
        return BugType;
    }

    public String getPriorty() {
        return Priorty;
    }

 
    public String getStatue() {
        return Statue;
    }

       
    }