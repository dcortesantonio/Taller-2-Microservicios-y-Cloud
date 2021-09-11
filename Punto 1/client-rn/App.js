import React from 'react';
import AppContainer from './AppContainer';
import {Provider as PaseosProvider} from './src/context/PaseoContext';

export default function App() {
  return (
    <PaseosProvider>
      <AppContainer />
    </PaseosProvider>
  );
}
