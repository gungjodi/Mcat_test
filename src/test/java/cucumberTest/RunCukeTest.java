package cucumberTest;

/**
 * Created by Agung_P1706 on 09/02/2017.
 */
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
//                "src/features/A_LoadRawData_Test.feature",
//                "src/features/B_LoadDictionaryData_Test.feature",
//                "src/features/C_NameTheItem_test.feature",
//                "src/features/D_NameItemsFromChecklist.feature",
//                "src/features/E_CreateNewInc.feature",
//                "src/features/F_CreateNewNsc.feature",
//                "src/features/G_CreateNewUNSPSC.feature",
//                "src/features/H_CreateAttributeGroup.feature",
//                "src/features/I_CreateNewAttribute.feature",
//                "src/features/J_SetupIncConfig.feature",
//                "src/features/K_AssignItem.feature",
//                "src/features/L_AssignItemFromChecklist.feature",
//                "src/features/M_SubmitAssignedItem.feature",
//                "src/features/N_SubmitAssignedItemFromCheckList.feature",
//                "src/features/O_ReviewItem.feature",
//                "src/features/P_ReviewItemFromCheckList.feature",
//                "src/features/Q_AdvanceSearch.feature",
//                "src/features/Q_AdvanceSearch_S2.feature",
                "src/features/Q_AdvanceSearch_S3.feature",
        },
        glue = "StepDefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber",
        }

)
public class RunCukeTest {
}
