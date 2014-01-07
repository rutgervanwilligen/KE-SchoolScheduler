package sss.reasoner;

import sss.scheduler.objects.Schedule;
import sss.scheduler.objects.Lesson;
import sss.scheduler.objects.Teacher;
import sss.scheduler.objects.ClassInSchool;

/**
 * Rule base used to evaluate a schedule.
 */
  class Jeops_RuleBase_ScheduleEvaluationKB extends jeops.AbstractRuleBase {

  
    /**
     * Identifiers of rule evaluationRule1
     */
    private String[] identifiers_evaluationRule1 = {
        "schedule",
        "lesson",
        "teacher",
        "classInSchool"
    };

    /**
     * Returns the identifiers declared in rule evaluationRule1
     *
     * @return the identifiers declared in rule evaluationRule1
     */
    private String[] getDeclaredIdentifiers_evaluationRule1() {
         return identifiers_evaluationRule1;
    }

    /**
     * Returns the name of the class of one declared object for
     * rule evaluationRule1.
     *
     * @param index the index of the declaration
     * @return the name of the class of the declared objects for
     *          this rule.
     */
    private String getDeclaredClassName_evaluationRule1(int index) {
        switch (index) {
            case 0: return "sss.scheduler.objects.Schedule";
            case 1: return "sss.scheduler.objects.Lesson";
            case 2: return "sss.scheduler.objects.Teacher";
            case 3: return "sss.scheduler.objects.ClassInSchool";
            default: return null;
        }
    }

    /**
     * Returns the class of one declared object for rule evaluationRule1.
     *
     * @param index the index of the declaration
     * @return the class of the declared objects for this rule.
     */
    private Class getDeclaredClass_evaluationRule1(int index) {
        switch (index) {
            case 0: return sss.scheduler.objects.Schedule.class;
            case 1: return sss.scheduler.objects.Lesson.class;
            case 2: return sss.scheduler.objects.Teacher.class;
            case 3: return sss.scheduler.objects.ClassInSchool.class;
            default: return null;
        }
    }

    /**
     * Sets an object declared in the rule evaluationRule1.
     *
     * @param index the index of the declared object
     * @param value the value of the object being set.
     */
    private void setObject_evaluationRule1(int index, Object value) {
        switch (index) {
            case 0: this.sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) value; break;
            case 1: this.sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) value; break;
            case 2: this.sss_scheduler_objects_Teacher_1 = (sss.scheduler.objects.Teacher) value; break;
            case 3: this.sss_scheduler_objects_ClassInSchool_1 = (sss.scheduler.objects.ClassInSchool) value; break;
        }
    }

    /**
     * Returns an object declared in the rule evaluationRule1.
     *
     * @param index the index of the declared object
     * @return the value of the corresponding object.
     */
    private Object getObject_evaluationRule1(int index) {
        switch (index) {
            case 0: return sss_scheduler_objects_Schedule_1;
            case 1: return sss_scheduler_objects_Lesson_1;
            case 2: return sss_scheduler_objects_Teacher_1;
            case 3: return sss_scheduler_objects_ClassInSchool_1;
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations 
     * of rule evaluationRule1
     *
     * @return an object array of the variables bound to the
     *          declarations of this rule.
     */
    private Object[] getObjects_evaluationRule1() {
        return new Object[] {
                            sss_scheduler_objects_Schedule_1,
                            sss_scheduler_objects_Lesson_1,
                            sss_scheduler_objects_Teacher_1,
                            sss_scheduler_objects_ClassInSchool_1
                            };
    }

    /**
     * Defines all variables bound to the declarations 
     * of rule evaluationRule1
     *
     * @param objects an object array of the variables bound to the
     *          declarations of this rule.
     */
    private void setObjects_evaluationRule1(Object[] objects) {
        sss_scheduler_objects_Schedule_1 = (sss.scheduler.objects.Schedule) objects[0];
        sss_scheduler_objects_Lesson_1 = (sss.scheduler.objects.Lesson) objects[1];
        sss_scheduler_objects_Teacher_1 = (sss.scheduler.objects.Teacher) objects[2];
        sss_scheduler_objects_ClassInSchool_1 = (sss.scheduler.objects.ClassInSchool) objects[3];
    }

    /**
     * Condition 0 of rule evaluationRule1.<p>
     * The original expression was:<br>
     * <code>schedule.containsAllocatedLesson(lesson)</code>
     *
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean evaluationRule1_cond_0() {
        return (sss_scheduler_objects_Schedule_1.containsAllocatedLesson(sss_scheduler_objects_Lesson_1));
    }

    /**
     * Checks whether some conditions of rule evaluationRule1 is satisfied.
     *
     * @param index the index of the condition to be checked.
     * @return <code>true</code> if the condition is satisfied;
     *          <code>false</code> otherwise.
     */
    private boolean evaluationRule1_cond(int index) {
        switch (index) {
            case 0: return evaluationRule1_cond_0();
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of rule evaluationRule1 that depend only on
     * the given object are satisfied.
     *
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          this rule are satisfied; <code>false</code> otherwise.
     */
    private boolean checkConditionsOnlyOf_evaluationRule1(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference some declared element of the declarations are
     * true.
     *
     * @param declIndex the index of the declared element.
     * @return <code>true</code> if the conditions that reference
     *          up to the given declaration are true;
     *          <code>false</code> otherwise.
     */
    private boolean checkCondForDeclaration_evaluationRule1(int declIndex) {
        switch (declIndex) {
            case 0:
                return true;
            case 1:
                if (!evaluationRule1_cond_0()) return false;
                return true;
            case 2:
                return true;
            case 3:
                return true;
            default: return false;
        }
    }

    /**
     * Executes the action part of the rule evaluationRule1
     */
    private void evaluationRule1() {
      System.out.println("evaluationRule1 fired");
      modified(sss_scheduler_objects_Schedule_1);
      }



    /**
     * The names of the rules in this class file
     */
    private static final String[] File_ruleNames = {
        "evaluationRule1"
    };

    /**
     * Returns the name of the rules in this class file.
     *
     * @return the name of the rules in this class file.
     */
    public String[] getRuleNames() {
        return File_ruleNames;
    }

    /**
     * The number of declarations of the rules in this class file.
     */
    private static final int[] File_numberOfDeclarations = {
        4
    };

    /**
     * Returns the number of declarations of the rules in this class file.
     *
     * @return the number of declarations  of the rules in this class file.
     */
    public int[] getNumberOfDeclarations() {
        return File_numberOfDeclarations;
    }

    /**
     * The number of conditions of the rules in this class file.
     */
    private static final int[] File_numberOfConditions = {
        1
    };

    /**
     * Returns the number of conditions of the rules in this class file.
     *
     * @return the number of conditions  of the rules in this class file.
     */
    public int[] getNumberOfConditions() {
        return File_numberOfConditions;
    }

    /**
     * Checks whether a condition of some rule is satisfied.
     *
     * @param ruleIndex the index of the rule to be checked
     * @param condIndex the index of the condition to be checked
     * @return <code>true</code> if the corresponding condition for the
     *          given rule is satisfied. <code>false</code> otherwise.
     */
    public boolean checkCondition(int ruleIndex, int condIndex) {
        switch (ruleIndex) {
            case 0: return evaluationRule1_cond(condIndex);
            default: return false;
        }
    }

    /**
     * Checks whether all conditions of some rule that depend only on
     * the given object are satisfied.
     *
     * @param ruleIndex the index of the rule to be checked
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all corresponding conditions for
     *          the given rule are satisfied;
     *           <code>false</code> otherwise.
     */
    public boolean checkConditionsOnlyOf(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return checkConditionsOnlyOf_evaluationRule1(declIndex);
            default: return false;
        }
    }

    /**
     * Checks whether all the conditions of a rule which
     * reference only the elements declared up to the given index
     * are true.
     *
     * @param ruleIndex the index of the rule to be checked
     * @param declIndex the index of the declaration to be checked
     * @return <code>true</code> if all the conditions of a rule which
     *          reference only the elements declared up to the given index
     *          are satisfied; <code>false</code> otherwise.
     */
    public boolean checkCondForDeclaration(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return checkCondForDeclaration_evaluationRule1(declIndex);
            default: return false;
        }
    }

    /**
     * Returns the class name of an object declared in a rule.
     *
     * @param ruleIndex the index of the rule
     * @param declIndex the index of the declaration
     * @return the class name of the declared object.
     */
    public String getDeclaredClassName(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return getDeclaredClassName_evaluationRule1(declIndex);
            default: return null;
        }
    }

    /**
     * Returns the class of an object declared in a rule.
     *
     * @param ruleIndex the index of the rule
     * @param declIndex the index of the declaration
     * @return the class of the declared object.
     */
    public Class getDeclaredClass(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return getDeclaredClass_evaluationRule1(declIndex);
            default: return null;
        }
    }

    /**
     * Fires one of the rules in this rule base.
     *
     * @param ruleIndex the index of the rule to be fired
     */
    protected void internalFireRule(int ruleIndex) {
        switch (ruleIndex) {
            case 0: evaluationRule1(); break;
        }
    }

    /**
     * Returns the number of rules.
     *
     * @return the number of rules.
     */
    public int getNumberOfRules() {
        return 1;
    }

    /**
     * Returns the identifiers declared in a given rule.
     *
     * @param ruleIndex the index of the rule.
     * @return an array with the identifiers of the rule declarations.
     */
    public String[] getDeclaredIdentifiers(int ruleIndex) {
        switch (ruleIndex) {
            case 0: return getDeclaredIdentifiers_evaluationRule1();
            default: return new String[0];
        }
    }

    /**
     * Sets an object that represents a declaration of some rule.
     *
     * @param ruleIndex the index of the rule
     * @param declIndex the index of the declaration in the rule.
     * @param value the value of the object being set.
     */
    public void setObject(int ruleIndex, int declIndex, Object value) {
        switch (ruleIndex) {
            case 0: setObject_evaluationRule1(declIndex, value); break;
        }
    }

    /**
     * Returns an object that represents a declaration of some rule.
     *
     * @param ruleIndex the index of the rule
     * @param declIndex the index of the declaration in the rule.
     * @return the value of the corresponding object.
     */
    public Object getObject(int ruleIndex, int declIndex) {
        switch (ruleIndex) {
            case 0: return getObject_evaluationRule1(declIndex);
            default: return null;
        }
    }

    /**
     * Returns all variables bound to the declarations of
     * some rule.
     *
     * @param ruleIndex the index of the rule
     * @return an object array of the variables bound to the
     *          declarations of some rule.
     */
    public Object[] getObjects(int ruleIndex) {
        switch (ruleIndex) {
            case 0: return getObjects_evaluationRule1();
            default: return null;
        }
    }
    /**
     * Defines all variables bound to the declarations of
     * some rule.
     *
     * @param ruleIndex the index of the rule
     * @param objects an object array of the variables bound to the
     *          declarations of some rule.
     */
    public void setObjects(int ruleIndex, Object[] objects) {
        switch (ruleIndex) {
            case 0: setObjects_evaluationRule1(objects); break;
        }
    }

    /*
     * The variables declared in the rules.
     */
    private sss.scheduler.objects.Schedule sss_scheduler_objects_Schedule_1;
    private sss.scheduler.objects.Lesson sss_scheduler_objects_Lesson_1;
    private sss.scheduler.objects.Teacher sss_scheduler_objects_Teacher_1;
    private sss.scheduler.objects.ClassInSchool sss_scheduler_objects_ClassInSchool_1;

    /**
     * Class constructor.
     *
     * @param knowledgeBase the knowledge base that contains this rule base.
     */
    public Jeops_RuleBase_ScheduleEvaluationKB(jeops.AbstractKnowledgeBase knowledgeBase) {
        super(knowledgeBase);
    }

}
/**
 * Knowledge base created by JEOPS from file ScheduleEvaluationKB.rules
 *
 * @version Jan 7, 2014
 */
public class ScheduleEvaluationKB extends jeops.AbstractKnowledgeBase {

    /**
     * Creates a new knowledge base with the specified conflict set with the
     * desired conflict resolution policy.
     *
     * @param conflictSet a conflict set with the desired resolution policy
     */
    public ScheduleEvaluationKB(jeops.conflict.ConflictSet conflictSet) {
        super(conflictSet);
    }

    /**
     * Creates a new knowledge base, using the default conflict resolution
     * policy.
     */
    public ScheduleEvaluationKB() {
        this(new jeops.conflict.DefaultConflictSet());
    }

    /**
     * Factory method used to instantiate the rule base.
     */
    protected jeops.AbstractRuleBase createRuleBase() {
        return new Jeops_RuleBase_ScheduleEvaluationKB(this);
    }

}
