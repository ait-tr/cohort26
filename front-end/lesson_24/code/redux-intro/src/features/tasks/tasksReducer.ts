// eslint-disable-next-line import/no-extraneous-dependencies
import { uid } from 'uid';
import Action from './types/Action';
import TasksState from './types/TasksState';

// начальное значение централизованного состояния
const initialState: TasksState = [
  {
    id: uid(),
    title: 'Изучить реакт',
    description: 'Изучить Redux, ccs modules и тд',
    isDone: false
  }
];

export default function tasksReducer(
  state: TasksState = initialState,
  action: Action
): TasksState {
  switch (action.type) {
    case 'tasks/add':
      return [...state, { ...action.payload, id: uid() }];
    case 'tasks/changeStatus':
      return state.map(
        (task) => (task.id === action.payload ? { ...task, isDone: !task.isDone } : task)
      );
    case 'tasks/remove':
      return state.filter((task) => task.id !== action.payload);
    default:
      return state;
  }
}
