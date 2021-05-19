// import {Reducer} from "./production.reducer.ts";
// import {Action} from "./production.actions";
//
// class Store<T> {
//   private _state: T;
//   private _listeners: ListenerCallback[] = [];
//
//   constructor(
//     private reducer: Reducer<T>,
//     initialState: T
//   ) {
//     this._state = initialState;
//   }
//
//   getState(): T {
//     return this._state;
//   }
//
//   dispatch(action: Action): void {
//     this._state = this.reducer(this._state, action);
//     this._listeners.forEach((listener: ListenerCallback) => listener());
//   }
//
//   subscribe(listener: ListenerCallback): UnsubscribeCallback {
//     this._listeners.push(listener);
//     return () => { // returns an "unsubscribe" function
//       this._listeners = this._listeners.filter(l => l !== listener);
//     };
//   }
// }
//
// let reducer: Reducer<number> = (state: number, action: Action) => {
//   switch (action.type) {
//     case 'INCREMENT':
//       return state + 1;
//     case 'DECREMENT':
//       return state - 1;
//     case 'PLUS':
//       return state + action.payload;
//     default:
//       return state; // <-- dont forget!
//   }
// };
//
// let store = new Store<number>(reducer, 0);
// console.log(store.getState()); // -> 0
//
// let unsubscribe = store.subscribe(() => {
//   console.log('subscribed: ', store.getState());
// });
//
// store.dispatch({ type: 'INCREMENT' }); // -> subscribed: 1
// store.dispatch({ type: 'INCREMENT' }); // -> subscribed: 2
//
// unsubscribe();
// store.dispatch({ type: 'DECREMENT' }); // (nothing logged)
// // store.dispatch({ type: 'INCREMENT' });
// // console.log(store.getState()); // -> 1
// //
// // store.dispatch({ type: 'INCREMENT' });
// // console.log(store.getState()); // -> 2
// //
// // store.dispatch({ type: 'DECREMENT' });
// // console.log(store.getState()); // -> 1
