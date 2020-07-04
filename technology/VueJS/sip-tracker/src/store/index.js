import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    funds: [
      'Canara Robeco Emerging Equities Fund',
      'DSP Small Cap Fund',
      'Franklin India Samller Companies Fund',
      'Mirae Asset Emerging Bluechip Fund',
      'Principal Emerging Bluechip Fund',
      'UTI Banking Fund'],
    portfolio: [
      {
        folio: '2627332284',
        name: 'Canara Robeco Emerging Equities Fund',
        units: 2838.866,
        nav: 95.47,
        investment: 200000,
      }, {
        folio: '3477342',
        name: 'DSP Small Cap Fund',
        units: 2835.102,
        nav: 51.911,
        investment: 200000,
      }, {
        folio: '27264111',
        name: 'Franklin India Samller Companies Fund',
        units: 4467.219,
        nav: 43.8652,
        investment: 200000,
      }, {
        folio: '3477342',
        name: 'Mirae Asset Emerging Bluechip Fund',
        units: 2922.48,
        nav: 55.816,
        investment: 200000,
      }, {
        folio: '67851847',
        name: 'Principal Emerging Bluechip Fund',
        units: 962.287,
        nav: 103.65,
        investment: 200000,
      }, {
        folio: '603217690185',
        name: 'UTI Banking Fund',
        units: 2558.959,
        nav: 74.26,
        investment: 200000,
      },
    ],
    nav: [
      {
        name: 'Canara Robeco Emerging Equities Fund',
        currentDate: '02-07-2020',
        curentNav: 96.30,
        history: [
          {
            date: '02-07-2020',
            nav: 96.30,
          },
        ],
      },
      {
        name: 'DSP Small Cap Fund',
        currentDate: '02-07-2020',
        curentNav: 51.911,
        history: [
          {
            date: '02-07-2020',
            nav: 51.911,
          },
        ],
      }, {
        name: 'Franklin India Samller Companies Fund',
        currentDate: '02-07-2020',
        curentNav: 43.8652,
        history: [
          {
            date: '02-07-2020',
            nav: 43.8652,
          },
        ],

      }, {
        name: 'Mirae Asset Emerging Bluechip Fund',
        currentDate: '02-07-2020',
        curentNav: 55.816,
        history: [
          {
            date: '02-07-2020',
            nav: 55.816,
          },
        ],

      }, {
        name: 'Principal Emerging Bluechip Fund',
        currentDate: '02-07-2020',
        curentNav: 103.65,
        history: [
          {
            date: '02-07-2020',
            nav: 103.65,
          },
        ],

      }, {
        name: 'UTI Banking Fund',
        currentDate: '02-07-2020',
        curentNav: 74.26,
        history: [
          {
            date: '02-07-2020',
            nav: 74.26,
          },
        ],

      },
    ],
    investments: [
      {
        name: 'Canara Robeco Emerging Equities Fund',
        sip: [
          {
            date: '01-06-2019',
            nav: 83.9,
            units: 11.92,
          },
        ],
      },
    ],
  },
  mutations: {
  },
  actions: {
  },
  modules: {
  },
  getters: {
    supportedFunds: (state) => state.funds,
    myPortfolio: (state) => state.portfolio,
    navHistory: (state) => state.nav,
  },
});
