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
    stocksList: [],
    stocks: [
      {
        name: 'maruti',
        totalQuantity: 30,
        currentDate: '7-7-2020',
        currentPrice: 6268.65,
        investments: [
          { date: '26-10-2017', qty: 1, price: 7991.84 },
          { date: '30-10-2017', qty: 1, price: 8308.89 },
          { date: '1-12-2017', qty: 1, price: 8671.29 },
          { date: '10-1-2018', qty: 1, price: 9410.63 },
          { date: '1-2-2018', qty: 1, price: 9558.89 },
          { date: '28-2-2018', qty: 1, price: 8897.64 },
          { date: '2-4-2018', qty: 1, price: 9092.95 },
          { date: '5-12-2018', qty: 1, price: 7615.37 },
          { date: '18-2-2019', qty: 1, price: 6935.01 },
          { date: '6-3-2019', qty: 1, price: 7100.08 },
          { date: '18-4-2019', qty: 1, price: 7523.83 },
          { date: '30-4-2019', qty: 1, price: 6721.11 },
          { date: '20-3-2020', qty: 3, price: 4918.11 },
          { date: '27-3-2020', qty: 1, price: 4680.92 },
          { date: '1-4-2020', qty: 1, price: 4294.76 },
          { date: '8-4-2020', qty: 1, price: 4801.52 },
          { date: '20-4-2020', qty: 1, price: 5604.94 },
          { date: '20-4-2020', qty: 1, price: 5441.79 },
          { date: '27-4-2020', qty: 1, price: 5136.03 },
          { date: '4-5-2020', qty: 1, price: 5116.28 },
          { date: '11-5-2020', qty: 1, price: 4851.73 },
          { date: '22-5-2020', qty: 1, price: 5017.28 },
          { date: '26-5-2020', qty: 1, price: 5270.79 },
          { date: '1-6-2020', qty: 1, price: 5844.79 },
          { date: '8-6-2020', qty: 1, price: 5836.34 },
          { date: '15-6-2020', qty: 1, price: 5567.88 },
          { date: '22-6-2020', qty: 1, price: 5919.59 },
          { date: '29-6-2020', qty: 1, price: 5824.09 },
        ],
      },
    ],
  },
  mutations: {
    addNav: (state, payload) => {
      console.log(payload);
      state.nav.forEach((element, index) => {
        if (element.name === payload.name) {
          state.nav[index].currentDate = payload.date;
          state.nav[index].curentNav = payload.nav;
          state.nav[index].history.unshift({ date: payload.date, nav: payload.nav });
        }
      });
    },
  },
  actions: {
  },
  modules: {
  },
  getters: {
    supportedFunds: (state) => state.funds,
    myPortfolio: (state) => state.portfolio,
    navHistory: (state) => state.nav,
    investments: (state) => state.investments,
    stocks: (state) => state.stocks,
  },
});
