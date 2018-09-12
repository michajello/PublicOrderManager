import { OrderDetails } from './OrderDetailsSejmometr';

export interface OrderSejmometr {
  'id': number;
  'dataset': String;
  'url': String;
  'mp_url': String;
  'schema_url': String;
  'global_id': number;
  'slug': String;
  'score': any;
  'data': OrderDetails;
  'layers': {
    'dataset': any;
    'channels': any;
    'page': any;
    'subscribers': any
  };
  'Aggs': {
    '_page': {
      'doc_count': number;
      'page': {
        'hits': {
          'total': number;
          'max_score': any;
          'hits': any[];
        }
      }
    }
  };
}
