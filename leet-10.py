# NFA
class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        def addState(state, index):
            if index not in state:
                state.add(index)
                if index < len(p):
                    if p[index] == '*':
                        addState(state, index + 1)
                    elif index + 1 < len(p) and p[index + 1] == '*':
                        addState(state, index + 2)

        def nextStates(states, char):
            new_states = set()
            for index in states:
                if index < len(p):
                    if p[index] == char or p[index] == '.':
                        addState(new_states, index + 1)
                    elif p[index] == '*':
                        if p[index - 1] == char or p[index - 1] == '.':
                            addState(new_states, index)
            return new_states

        current_states = set()
        addState(current_states, 0)

        for char in s:
            current_states = nextStates(current_states, char)
            if not current_states:
                return False

        for index in current_states:
            if index == len(p):
                return True
            if index < len(p) - 1 and p[index] == '*':
                if index + 1 == len(p):
                    return True

        return False


#DP
