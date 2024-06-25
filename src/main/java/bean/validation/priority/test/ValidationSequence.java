package bean.validation.priority.test;

import jakarta.validation.GroupSequence;

@GroupSequence({ValidationGroups.First.class
        , ValidationGroups.Second.class
        , ValidationGroups.Third.class
        , ValidationGroups.Forth.class})
public interface ValidationSequence {
}
